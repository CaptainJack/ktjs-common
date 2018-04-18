package ru.capjack.ktjs.common.geom

fun <T> axial(horizontal: T, vertical: T): AxialValues<T> {
	return AxialValuesImpl(horizontal, vertical)
}

fun <T> axial(both: T): AxialValues<T> {
	return AxialValuesImpl(both)
}


fun <T> axial(supplier: (axis: Axis) -> T): AxialValues<T> {
	return AxialValuesImpl(
		supplier(Axis.HORIZONTAL),
		supplier(Axis.VERTICAL)
	)
}

fun <T> axial(axis: Axis, axisValue: T, oppositeAxisValue: T): AxialValues<T> {
	return when (axis) {
		Axis.HORIZONTAL -> AxialValuesImpl(axisValue, oppositeAxisValue)
		Axis.VERTICAL   -> AxialValuesImpl(oppositeAxisValue, axisValue)
	}
}


fun <T> mutableAxial(horizontal: T, vertical: T): MutableAxialValues<T> {
	return MutableAxialValuesImpl(horizontal, vertical)
}

fun <T> mutableAxial(both: T): MutableAxialValues<T> {
	return MutableAxialValuesImpl(both)
}

fun axialInt(horizontal: Number, vertical: Number): AxialValues<Int> {
	return AxialValuesImpl(horizontal.toInt(), vertical.toInt())
}

fun axialDouble(horizontal: Number, vertical: Number): AxialValues<Double> {
	return AxialValuesImpl(horizontal.toDouble(), vertical.toDouble())
}

fun insets(both: Int): Insets<Int> {
	return IntInsets(both)
}

fun insets(horizontal: Int, vertical: Int): Insets<Int> {
	return IntInsets(horizontal, vertical)
}

fun insets(left: Int, right: Int, top: Int, bottom: Int): Insets<Int> {
	return IntInsets(left, right, top, bottom)
}


fun rect(x: Int, y: Int, width: Int, height: Int): Rectangle<Int> {
	return IntRectangle(x, y, width, height)
}
