package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.time.TimeSystem

abstract class NumberFlowBase<T : Number>(
	value: T,
	private val timeSystem: TimeSystem,
	private val tickDeltaCalculator: (from: T, to: T, current: T, step: Int) -> T,
	private val tickTime: Int,
	private val maxTime: Int

) : NumberFlow<T> {
	
	final override var current: T = value
		private set
	
	private var target: T = value
	private var ticker: Ticker? = null
	private val handlers = ProcedureGroup()
	
	override fun onChange(handler: (current: T, delta: T) -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun onChange(handler: (current: T) -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun onChange(handler: () -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun seek(value: T) {
		if (target == value) {
			return
		}
		
		target = value
		
		if (current == target) {
			stop()
		} else {
			ticker = Ticker(current)
		}
	}
	
	override fun set(value: T) {
		if (current == value) {
			return
		}
		stop()
		target = value
		val delta = subtract(target, current)
		current = target
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
		val source: T
	) {
		
		private val task = timeSystem.scheduleRepeatable(tickTime, ::tick)
		private var time: Double = 0.0
		private var step: Int = 0
		
		fun stop() {
			task.cancel()
		}
		
		private fun tick(passedTime: Double) {
			time += passedTime
			
			if (time >= maxTime) {
				set(target)
			} else {
				val diff = subtract(target, current)
				var delta = tickDeltaCalculator.invoke(source, target, current, step)
				
				if (delta == 0) {
					delta = diff
				} else if (great(target, current)) {
					if (great(delta, diff)) {
						delta = diff
					}
				} else if (great(diff, delta)) {
					delta = diff
				}
				
				current = add(current, delta)
				
				invokeHandlers(delta)
				
				if (current == target) {
					stop()
				}
			}
		}
	}
	
	protected abstract fun great(a: T, b: T): Boolean
	
	protected abstract fun subtract(a: T, b: T): T
	
	protected abstract fun add(a: T, b: T): T
}