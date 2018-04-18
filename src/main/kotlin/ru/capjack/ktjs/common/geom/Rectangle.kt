package ru.capjack.ktjs.common.geom

interface Rectangle<T> {
	val position: AxialValues<T>
	val size: AxialValues<T>
	
	val x: T
	val y: T
	val width: T
	val height: T
	
	fun contains(x: T, y: T): Boolean
	
	fun contains(p: AxialValues<T>): Boolean
}
