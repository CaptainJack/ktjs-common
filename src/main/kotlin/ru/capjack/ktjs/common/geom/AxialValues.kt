package ru.capjack.ktjs.common.geom

interface AxialValues<T> {
	val x: T
	val y: T
	
	operator fun get(axis: Axis): T
	
	fun rotate(): AxialValues<T>
	
	fun isEquals(both: T): Boolean
	
	fun isEquals(x: T, y: T): Boolean
	
	fun isEquals(v: AxialValues<T>): Boolean
}