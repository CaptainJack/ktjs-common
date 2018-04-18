package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.time.TimeSystem

class FlowNumberInt(
	timeSystem: TimeSystem,
	deltaCalculator: (diff: Int) -> Int,
	value: Int = 0,
	maxTime: Int = Int.MAX_VALUE,
	tickTime: Int = 20
) : FlowNumberBase<Int>(timeSystem, deltaCalculator, value, maxTime, tickTime) {
	
	override fun compare(a: Int, b: Int) = a.compareTo(b)
	
	override fun subtract(a: Int, b: Int) = a - b
	
	override fun add(a: Int, b: Int) = a + b
}

