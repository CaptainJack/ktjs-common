package ru.capjack.ktjs.common.geom

fun <T : Comparable<T>> MutableAxialValues<T>.setMax(axis: Axis, value: T) {
	if (get(axis) < value) {
		set(axis, value)
	}
}

fun <T : Comparable<T>> MutableAxialValues<T>.setMax(x: T, y: T) {
	val h = this.x < x
	val v = this.y < y
	when {
		h && v -> set(x, y)
		h      -> this.x = x
		v      -> this.y = y
	}
}