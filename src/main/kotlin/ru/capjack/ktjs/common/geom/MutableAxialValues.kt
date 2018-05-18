package ru.capjack.ktjs.common.geom

interface MutableAxialValues<T> : AxialValues<T> {
	override var x: T
	override var y: T
	
	operator fun set(axis: Axis, value: T): T
	
	fun set(both: T)
	
	fun set(x: T, y: T)
	
	fun set(values: AxialValues<T>)
	
	fun set(axis: Axis, axisValue: T, oppositeAxisValue: T)
}