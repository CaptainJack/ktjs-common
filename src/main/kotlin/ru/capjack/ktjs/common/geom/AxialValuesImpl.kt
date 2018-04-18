package ru.capjack.ktjs.common.geom

open class AxialValuesImpl<T>(
	override val horizontal: T,
	override val vertical: T
) : AxialValues<T> {
	
	constructor(both: T) : this(both, both)
	
	override fun toString(): String {
		return "$horizontal:$vertical"
	}
}