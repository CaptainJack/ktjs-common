package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.time.TimeSystem

class NumberFlowDouble(
	value: Double,
	timeSystem: TimeSystem,
	tickDeltaCalculator: (from: Double, to: Double, current: Double, step: Int) -> Double,
	tickTime: Int = 20,
	maxTime: Int = Int.MAX_VALUE
) : NumberFlowBase<Double>(value, timeSystem, tickDeltaCalculator, tickTime, maxTime) {
	
	override fun great(a: Double, b: Double) = a > b
	
	override fun subtract(a: Double, b: Double) = a - b
	
	override fun add(a: Double, b: Double) = a + b
}

