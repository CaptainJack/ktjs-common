package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.time.TimeSystem

class NumberFlowInt(
	value: Int,
	timeSystem: TimeSystem,
	tickDeltaCalculator: (from: Int, to: Int, current: Int, step: Int) -> Int,
	tickTime: Int = 20,
	maxTime: Int = Int.MAX_VALUE
) : NumberFlowBase<Int>(value, timeSystem, tickDeltaCalculator, tickTime, maxTime) {
	
	override fun great(a: Int, b: Int) = a > b
	
	override fun subtract(a: Int, b: Int) = a - b
	
	override fun add(a: Int, b: Int) = a + b
}

