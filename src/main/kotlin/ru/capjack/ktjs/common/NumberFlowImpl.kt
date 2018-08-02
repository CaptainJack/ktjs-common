package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.math.IntArithmetic
import ru.capjack.ktjs.common.math.LongArithmetic
import ru.capjack.ktjs.common.math.NumberArithmetic
import ru.capjack.ktjs.common.time.TimeSystem
import ru.capjack.ktjs.common.time.scheduleRepeatable

class NumberFlowImpl<T : Number>(
	value: T,
	private val timeSystem: TimeSystem,
	private val timeQualifier: (diff: T) -> Int,
	private val tickTime: Int,
	private val arithmetic: NumberArithmetic<T>
) : NumberFlow<T> {
	
	override var current: T = value
		private set
	
	private val handlers = ProcedureGroup()
	private var ticker: Ticker? = null
	
	override fun onChange(handler: (current: T, delta: T) -> Unit) = handlers.add(handler)
	
	override fun onChange(handler: (current: T) -> Unit) = handlers.add(handler)
	
	override fun onChange(handler: () -> Unit) = handlers.add(handler)
	
	override fun seek(value: T) {
		if (ticker?.target == value) {
			return
		}
		
		if (current == value) {
			stop()
		}
		else {
			val diff = arithmetic.subtract(value, current)
			val time = timeQualifier.invoke(diff)
			
			if (time < 0) {
				throw RuntimeException("Qualified time is negative")
			}
			
			val steps = time / tickTime
			val stepDelta = arithmetic.divide(diff, steps)
			
			if (steps == 0) {
				set(value)
			}
			else {
				ticker = Ticker(value, steps, stepDelta)
			}
		}
	}
	
	override fun set(value: T) {
		if (current == value) {
			return
		}
		stop()
		val delta = arithmetic.subtract(value, current)
		current = value
		invokeHandlers(delta)
	}
	
	private fun stop() {
		ticker?.stop()
		ticker = null
	}
	
	private fun invokeHandlers(delta: T) {
		handlers.invoke(current, delta)
	}
	
	private inner class Ticker(
		var target: T,
		private val steps: Int,
		private val delta: T
	) {
		private val task = timeSystem.scheduleRepeatable(tickTime, ::tick)
		private var step = 0
		
		fun stop() {
			task.cancel()
		}
		
		private fun tick() {
			if (++step == steps) {
				val delta = arithmetic.subtract(target, current)
				current = target
				invokeHandlers(delta)
				stop()
			}
			else {
				current = arithmetic.add(target, delta)
				invokeHandlers(delta)
			}
		}
	}
	
	companion object {
		fun create(value: Int, timeSystem: TimeSystem, timeQualifier: (diff: Int) -> Int, tickTime: Int = 32): NumberFlow<Int> {
			return NumberFlowImpl(value, timeSystem, timeQualifier, tickTime, IntArithmetic)
		}
		
		fun create(value: Long, timeSystem: TimeSystem, timeQualifier: (diff: Long) -> Int, tickTime: Int = 32): NumberFlow<Long> {
			return NumberFlowImpl(value, timeSystem, timeQualifier, tickTime, LongArithmetic)
		}
	}
}
