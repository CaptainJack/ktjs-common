package ru.capjack.ktjs.common.math

object ByteArithmetic : NumberArithmetic<Byte> {
	override fun add(a: Byte, b: Byte) = (a + b).toByte()
	
	override fun add(a: Byte, b: Number) = add(a, b.toByte())
	
	override fun subtract(a: Byte, b: Byte) = (a - b).toByte()
	
	override fun subtract(a: Byte, b: Number) = subtract(a, b.toByte())
	
	override fun multiply(a: Byte, b: Byte) = (a * b).toByte()
	
	override fun multiply(a: Byte, b: Number) = multiply(a, b.toByte())
	
	override fun divide(a: Byte, b: Byte) = (a / b).toByte()
	
	override fun divide(a: Byte, b: Number) = divide(a, b.toByte())
}