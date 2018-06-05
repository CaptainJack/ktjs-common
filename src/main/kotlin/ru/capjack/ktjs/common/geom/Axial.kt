package ru.capjack.ktjs.common.geom

interface Axial<T> {
	val x: T
	val y: T
	
	operator fun get(axis: Axis): T
	
	fun rotate(): Axial<T>
	
	fun isEquals(both: T): Boolean
	
	fun isEquals(x: T, y: T): Boolean
	
	fun isEquals(v: Axial<T>): Boolean
}