package ru.capjack.ktjs.common.geom

interface MutableAxial<T> : Axial<T> {
	override var x: T
	override var y: T
	
	operator fun set(axis: Axis, value: T): T
	
	fun set(both: T)
	
	fun set(x: T, y: T)
	
	fun set(values: Axial<T>)
	
	fun set(axis: Axis, axisValue: T, oppositeAxisValue: T)
}