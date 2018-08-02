package ru.capjack.ktjs.common.math

object LongArithmetic : NumberArithmetic<Long> {
	override fun add(a: Long, b: Long) = a + b
	
	override fun add(a: Long, b: Number) = add(a, b.toLong())
	
	override fun subtract(a: Long, b: Long) = a - b
	
	override fun subtract(a: Long, b: Number) = subtract(a, b.toLong())
	
	override fun multiply(a: Long, b: Long) = a * b
	
	override fun multiply(a: Long, b: Number) = multiply(a, b.toLong())
	
	override fun divide(a: Long, b: Long) = a / b
	
	override fun divide(a: Long, b: Number) = divide(a, b.toLong())
}