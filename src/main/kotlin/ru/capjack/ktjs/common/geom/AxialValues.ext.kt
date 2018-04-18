package ru.capjack.ktjs.common.geom

fun AxialValues<Int>.calculateRatio(dividendAxis: Axis): Double {
	return get(dividendAxis) / get(dividendAxis.opposite).toDouble()
}

fun <T : Comparable<T>> AxialValues<T>.isOutside(other: AxialValues<T>): Boolean {
	return (x >= other.x && y > other.y) || (x > other.x && y >= other.y)
}

fun <T : Comparable<T>> AxialValues<T>.isInside(other: AxialValues<T>): Boolean {
	return (x <= other.x && y < other.y) || (x < other.x && y <= other.y)
}

fun <T : Comparable<T>> AxialValues<T>.isInsideAtLeastOne(other: AxialValues<T>): Boolean {
	return x <= other.x || y <= other.y
}

inline fun <T> AxialValues<T>.forEach(block: (axis: Axis, value: T) -> Unit) {
	block(Axis.HORIZONTAL, x)
	block(Axis.VERTICAL, y)
}

inline fun <T> AxialValues<T>.forEachIf(value: T, block: (axis: Axis) -> Unit) {
	forEach { axis, v ->
		if (value == v) {
			block(axis)
		}
	}
}

fun AxialValues<Int>.negative(): AxialValues<Int> {
	return axial(-x, -y)
}