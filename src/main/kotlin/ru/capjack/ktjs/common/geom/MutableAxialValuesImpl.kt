package ru.capjack.ktjs.common.geom

open class MutableAxialValuesImpl<T>(
	override var x: T,
	override var y: T
) : AbstractAxialValues<T>(), MutableAxialValues<T> {
	
	override operator fun set(axis: Axis, value: T): T {
		when (axis) {
			Axis.X -> this.x = value
			Axis.Y -> this.y = value
		}
		return get(axis)
	}
	
	override fun set(both: T) {
		set(both, both)
	}
	
	override fun set(x: T, y: T) {
		this.x = x
		this.y = y
	}
	
	override fun set(values: AxialValues<T>) {
		set(values.x, values.y)
	}
	
	override fun set(axis: Axis, axisValue: T, oppositeAxisValue: T) {
		when (axis) {
			Axis.X -> set(axisValue, oppositeAxisValue)
			Axis.Y -> set(oppositeAxisValue, axisValue)
		}
	}
}