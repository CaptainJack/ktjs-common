package ru.capjack.ktjs.common.geom

fun <T : Comparable<T>> MutableAxialValues<T>.setMax(axis: Axis, value: T) {
	if (get(axis) < value) {
		set(axis, value)
	}
}

fun <T : Comparable<T>> MutableAxialValues<T>.setMax(horizontal: T, vertical: T) {
	val h = this.horizontal < horizontal
	val v = this.vertical < vertical
	when {
		h && v -> set(horizontal, vertical)
		h      -> this.horizontal = horizontal
		v      -> this.vertical = vertical
	}
}