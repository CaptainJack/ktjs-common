package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.time.TimeSystem

abstract class FlowNumberBase<T : Number>(
	private val timeSystem: TimeSystem,
	private val deltaCalculator: (diff: T) -> T,
	value: T,
	private val maxTime: Int,
	private val tickTime: Int

) : FlowNumber<T> {
	
	final override var current: T = value
		private set
	
	private val handlers = ProcedureGroup()
	
	private var target: T = value
	private var increase: Boolean = false
	private var tick: Cancelable? = null
	private var runningTime: Double = 0.0
	
	override fun onChange(handler: (current: T, delta: T) -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun seek(value: T) {
		if (target == value) {
			return
		}
		
		target = value
		
		if (current == target) {
			stop()
		}
		else {
			increase = compare(target, current) > 0
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
		val delta = if (compare(target, current) > 0) subtract(target, current) else subtract(current, target)
		current = target
		handlers.invoke(current, delta)
	}
	
	private fun tick(time: Double) {
		runningTime += time
		
		if (runningTime >= maxTime) {
			set(target)
		}
		else {
			val diff = if (increase) subtract(target, current) else subtract(current, target)
			var delta = deltaCalculator.invoke(diff)
			
			if (delta == 0) {
				stop()
				throw IllegalStateException("Calculated delta is 0")
			}
			
			if (compare(delta, diff) > 0) {
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
	
	protected abstract fun compare(a: T, b: T): Int
	
	protected abstract fun subtract(a: T, b: T): T
	
	protected abstract fun add(a: T, b: T): T
}
