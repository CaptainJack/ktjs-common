package ru.capjack.ktjs.common.geom

interface Insets<T : Number> : AxialValues<T> {
	val left: T
	val right: T
	val top: T
	val bottom: T
	
	val leftTop: AxialValues<T>
		get() = AxialValuesImpl(left, top)
}