package ru.capjack.ktjs.common.geom

interface AxialValues<T> {
	val horizontal: T
	val vertical: T
	
	val x: T
		get() = horizontal
	val y: T
		get() = vertical
	
	operator fun get(axis: Axis): T = when (axis) {
		Axis.HORIZONTAL -> horizontal
		Axis.VERTICAL   -> vertical
	}
	
	fun rotate(): AxialValues<T> = axial(vertical, horizontal)
	
	fun isEquals(value: T): Boolean {
		return horizontal == value && vertical == value
	}
	
	fun isEquals(horizontal: T, vertical: T): Boolean {
		return this.horizontal == horizontal && this.vertical == vertical
	}
	
	fun isEquals(other: AxialValues<T>): Boolean {
		return this === other || (horizontal == other.horizontal && vertical == other.vertical)
	}
}