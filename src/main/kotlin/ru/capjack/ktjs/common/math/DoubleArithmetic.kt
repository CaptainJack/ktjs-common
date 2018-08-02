package ru.capjack.ktjs.common.math

object DoubleArithmetic : NumberArithmetic<Double> {
	override fun add(a: Double, b: Double) = a + b
	
	override fun add(a: Double, b: Number) = add(a, b.toDouble())
	
	override fun subtract(a: Double, b: Double) = a - b
	
	override fun subtract(a: Double, b: Number) = subtract(a, b.toDouble())
	
	override fun multiply(a: Double, b: Double) = a * b
	
	override fun multiply(a: Double, b: Number) = multiply(a, b.toDouble())
	
	override fun divide(a: Double, b: Double) = a / b
	
	override fun divide(a: Double, b: Number) = divide(a, b.toDouble())
}