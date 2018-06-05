package ru.capjack.ktjs.common.geom

abstract class AbstractAxial<T> : Axial<T> {
	
	override operator fun get(axis: Axis): T {
		return when (axis) {
			Axis.X -> x
			Axis.Y -> y
		}
	}
	
	override fun toString(): String {
		return "$x:$y"
	}
}