package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.time.TimeSystem

class NumberFlowImpl<T>(
	value: T,
	private val timeSystem: TimeSystem,
	private val deltaCalculator: (diff: T) -> T,
	private val tickTime: Int = 20,
	private val maxTime: Int = Int.MAX_VALUE

) : NumberFlow<T> where T : Number, T : Comparable<T> {
	
	override var current: T = value
		private set
	
	private val handlers = ProcedureGroup()
	
	private var target: T = value
	private var increase: Boolean = false
	private var tick: Cancelable? = null
	private var runningTime: Double = 0.0
	
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
			increase = target > current
			runningTime = 0.0
			tick = timeSystem.scheduleRepeatable(tickTime, ::tick)
		}
	}
	
	override fun set(value: T) {
		if (current == value) {
			return
		}
		stop()
		target = value
		val delta = if (target > current) subtract(target, current) else subtract(current, target)
		current = target
		handlers.invoke(current, delta)
	}
	
	private fun tick(time: Double) {
		runningTime += time
		
		if (runningTime >= maxTime) {
			set(target)
		} else {
			val diff = if (increase) subtract(target, current) else subtract(current, target)
			var delta = deltaCalculator.invoke(diff)
			
			if (delta == 0) {
				stop()
				throw IllegalStateException("Calculated delta is 0")
			}
			
			if (delta > diff) {
				delta = diff
			}
			
			current = if (increase) add(current, delta) else subtract(current, delta)
			
			invokeHandlers(delta)
			
			if (current == target) {
				stop()
			}
		}
	}
	
	private fun stop() {
		tick?.cancel()
		tick = null
	}
	
	private fun invokeHandlers(delta: T) {
		handlers.invoke(current, delta)
	}
	
	@Suppress("UNUSED_PARAMETER")
	private fun subtract(a: T, b: T): T {
		return js("a - b") as T
	}
	
	@Suppress("UNUSED_PARAMETER")
	private fun add(a: T, b: T): T {
		return js("a + b") as T
	}
}
