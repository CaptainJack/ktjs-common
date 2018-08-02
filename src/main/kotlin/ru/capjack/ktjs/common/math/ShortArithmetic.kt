package ru.capjack.ktjs.common.math

object ShortArithmetic : NumberArithmetic<Short> {
	override fun add(a: Short, b: Short) = (a + b).toShort()
	
	override fun add(a: Short, b: Number) = add(a, b.toShort())
	
	override fun subtract(a: Short, b: Short) = (a - b).toShort()
	
	override fun subtract(a: Short, b: Number) = subtract(a, b.toShort())
	
	override fun multiply(a: Short, b: Short) = (a * b).toShort()
	
	override fun multiply(a: Short, b: Number) = multiply(a, b.toShort())
	
	override fun divide(a: Short, b: Short) = (a / b).toShort()
	
	override fun divide(a: Short, b: Number) = divide(a, b.toShort())
}