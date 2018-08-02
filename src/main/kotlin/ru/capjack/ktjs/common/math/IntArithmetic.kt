package ru.capjack.ktjs.common.math

object IntArithmetic : NumberArithmetic<Int> {
	override fun add(a: Int, b: Int) = a + b
	
	override fun add(a: Int, b: Number) = add(a, b.toInt())
	
	override fun subtract(a: Int, b: Int) = a - b
	
	override fun subtract(a: Int, b: Number) = subtract(a, b.toInt())
	
	override fun multiply(a: Int, b: Int) = a * b
	
	override fun multiply(a: Int, b: Number) = multiply(a, b.toInt())
	
	override fun divide(a: Int, b: Int) = a / b
	
	override fun divide(a: Int, b: Number) = divide(a, b.toInt())
}