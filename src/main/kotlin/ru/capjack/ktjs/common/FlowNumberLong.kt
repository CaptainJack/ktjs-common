package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.time.TimeSystem

class FlowNumberLong(
	timeSystem: TimeSystem,
	deltaCalculator: (diff: Long) -> Long,
	value: Long = 0,
	maxTime: Int = Int.MAX_VALUE,
	tickTime: Int = 20
) : FlowNumberBase<Long>(timeSystem, deltaCalculator, value, maxTime, tickTime) {
	
	override fun compare(a: Long, b: Long) = a.compareTo(b)
	
	override fun subtract(a: Long, b: Long) = a - b
	
	override fun add(a: Long, b: Long) = a + b
}

