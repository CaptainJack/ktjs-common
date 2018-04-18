package ru.capjack.ktjs.common.geom

interface MutableAxialValues<T> : AxialValues<T> {
	override var horizontal: T
	override var vertical: T
	
	override var x: T
		get() = horizontal
		set(value) {
			horizontal = value
		}
	
	override var y: T
		get() = vertical
		set(value) {
			vertical = value
		}
	
	operator fun set(axis: Axis, value: T): T {
		when (axis) {
			Axis.HORIZONTAL -> horizontal = value
			Axis.VERTICAL   -> vertical = value
		}
		return get(axis)
	}
	
	fun set(both: T) {
		set(both, both)
	}
	
	fun set(horizontal: T, vertical: T) {
		this.horizontal = horizontal
		this.vertical = vertical
	}
	
	fun set(values: AxialValues<T>) {
		set(values.horizontal, values.vertical)
	}
	
	fun set(axis: Axis, axisValue: T, oppositeAxisValue: T) {
		when (axis) {
			Axis.HORIZONTAL -> set(axisValue, oppositeAxisValue)
			Axis.VERTICAL   -> set(oppositeAxisValue, axisValue)
		}
	}
}