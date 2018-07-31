package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.time.TimeSystem

class NumberFlowLong(
	value: Long,
	timeSystem: TimeSystem,
	tickDeltaCalculator: (from: Long, to: Long, current: Long, step: Int) -> Long,
	tickTime: Int = 20,
	maxTime: Int = Int.MAX_VALUE
) : NumberFlowBase<Long>(value, timeSystem, tickDeltaCalculator, tickTime, maxTime) {
	
	override fun great(a: Long, b: Long) = a > b
	
	override fun subtract(a: Long, b: Long) = a - b
	
	override fun add(a: Long, b: Long) = a + b
}

