package ru.capjack.ktjs.common.geom

fun Axial<Int>.calculateRatio(dividendAxis: Axis): Double {
	return get(dividendAxis) / get(dividendAxis.opposite).toDouble()
}

fun <T : Comparable<T>> Axial<T>.isOutside(other: Axial<T>): Boolean {
	return (x >= other.x && y > other.y) || (x > other.x && y >= other.y)
}

fun <T : Comparable<T>> Axial<T>.isInside(other: Axial<T>): Boolean {
	return (x <= other.x && y < other.y) || (x < other.x && y <= other.y)
}

fun <T : Comparable<T>> Axial<T>.isInsideAtLeastOne(other: Axial<T>): Boolean {
	return x <= other.x || y <= other.y
}

inline fun <T> Axial<T>.forEach(block: (axis: Axis, value: T) -> Unit) {
	block(Axis.X, x)
	block(Axis.Y, y)
}

inline fun <T> Axial<T>.forEachIf(value: T, block: (axis: Axis) -> Unit) {
	forEach { axis, v ->
		if (value == v) {
			block(axis)
		}
	}
}

fun Axial<Int>.negative(): Axial<Int> {
	return axial(-x, -y)
}

fun <T> Axial<T>.rotate(): Axial<T> {
	return axial(y, x)
}

fun <T> Axial<T>.copy(): Axial<T> {
	return axial(x, y)
}

fun <T> Axial<T>.isEquals(both: T): Boolean {
	return x == both && y == both
}

fun <T> Axial<T>.isEquals(x: T, y: T): Boolean {
	return this.x == x && this.y == y
}

fun <T> Axial<T>.isEquals(v: Axial<T>): Boolean {
	return this === v || (x == v.x && y == v.y)
}