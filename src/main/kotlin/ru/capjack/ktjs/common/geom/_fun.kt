package ru.capjack.ktjs.common.geom

fun <T> axial(horizontal: T, vertical: T): Axial<T> {
	return AxialImpl(horizontal, vertical)
}

fun <T> axial(both: T): Axial<T> {
	return AxialImpl(both, both)
}


fun <T> axial(supplier: (axis: Axis) -> T): Axial<T> {
	return AxialImpl(
		supplier(Axis.X),
		supplier(Axis.Y)
	)
}

fun <T> axial(axis: Axis, axisValue: T, oppositeAxisValue: T): Axial<T> {
	return when (axis) {
		Axis.X -> AxialImpl(axisValue, oppositeAxisValue)
		Axis.Y -> AxialImpl(oppositeAxisValue, axisValue)
	}
}


fun <T> mutableAxial(horizontal: T, vertical: T): MutableAxial<T> {
	return MutableAxialImpl(horizontal, vertical)
}

fun <T> mutableAxial(both: T): MutableAxial<T> {
	return MutableAxialImpl(both, both)
}

fun axialInt(horizontal: Number, vertical: Number): Axial<Int> {
	return AxialImpl(horizontal.toInt(), vertical.toInt())
}

fun axialDouble(horizontal: Number, vertical: Number): Axial<Double> {
	return AxialImpl(horizontal.toDouble(), vertical.toDouble())
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
