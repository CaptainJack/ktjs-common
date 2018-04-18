package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.time.TimeSystem

class FlowNumberDouble(
	timeSystem: TimeSystem,
	deltaCalculator: (diff: Double) -> Double,
	value: Double = 0.0,
	maxTime: Int = Int.MAX_VALUE,
	tickTime: Int = 20
) : FlowNumberBase<Double>(timeSystem, deltaCalculator, value, maxTime, tickTime) {
	
	override fun compare(a: Double, b: Double) = a.compareTo(b)
	
	override fun subtract(a: Double, b: Double) = a - b
	
	override fun add(a: Double, b: Double) = a + b
}

