package ru.capjack.ktjs.common.math

interface NumberArithmetic<T : Number> {
	fun add(a: T, b: T): T
	
	fun add(a: T, b: Number): T
	
	fun subtract(a: T, b: T): T
	
	fun subtract(a: T, b: Number): T
	
	fun multiply(a: T, b: T): T
	
	fun multiply(a: T, b: Number): T
	
	fun divide(a: T, b: T): T
	
	fun divide(a: T, b: Number): T
}
