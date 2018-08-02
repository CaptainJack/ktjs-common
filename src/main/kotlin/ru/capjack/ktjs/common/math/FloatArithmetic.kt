package ru.capjack.ktjs.common.math

object FloatArithmetic : NumberArithmetic<Float> {
	override fun add(a: Float, b: Float) = a + b
	
	override fun add(a: Float, b: Number) = add(a, b.toFloat())
	
	override fun subtract(a: Float, b: Float) = a - b
	
	override fun subtract(a: Float, b: Number) = subtract(a, b.toFloat())
	
	override fun multiply(a: Float, b: Float) = a * b
	
	override fun multiply(a: Float, b: Number) = multiply(a, b.toFloat())
	
	override fun divide(a: Float, b: Float) = a / b
	
	override fun divide(a: Float, b: Number) = divide(a, b.toFloat())
}