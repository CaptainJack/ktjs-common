package ru.capjack.ktjs.common.geom

open class MutableAxialValuesImpl<T>(override var horizontal: T, override var vertical: T = horizontal) : MutableAxialValues<T> {
	
	constructor(values: AxialValues<T>) : this(values.horizontal, values.vertical)
	
	override fun toString(): String {
		return "$horizontal:$vertical"
	}
}