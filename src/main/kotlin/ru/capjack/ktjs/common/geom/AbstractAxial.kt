package ru.capjack.ktjs.common.geom

abstract class AbstractAxial<T> : Axial<T> {
	
	override operator fun get(axis: Axis): T {
		return when (axis) {
			Axis.X -> x
			Axis.Y -> y
		}
	}
	
	override fun rotate(): Axial<T> {
		return axial(y, x)
	}
	
	override fun isEquals(both: T): Boolean {
		return x == both && y == both
	}
	
	override fun isEquals(x: T, y: T): Boolean {
		return this.x == x && this.y == y
	}
	
	override fun isEquals(v: Axial<T>): Boolean {
		return this === v || (x == v.x && y == v.y)
	}
	
	override fun toString(): String {
		return "$x:$y"
	}
}