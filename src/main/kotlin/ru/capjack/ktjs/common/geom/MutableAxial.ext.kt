package ru.capjack.ktjs.common.geom

fun <T : Comparable<T>> MutableAxial<T>.setMax(axis: Axis, value: T) {
	if (get(axis) < value) {
		set(axis, value)
	}
}

fun <T : Comparable<T>> MutableAxial<T>.setMax(x: T, y: T) {
	val h = this.x < x
	val v = this.y < y
	when {
		h && v -> set(x, y)
		h      -> this.x = x
		v      -> this.y = y
	}
}

inline fun <T> MutableAxial<T>.change(axis: Axis, transform: (T) -> T) {
	set(axis, transform(get(axis)))
}

inline fun <T> MutableAxial<T>.change(transform: (T) -> T) {
	set(transform(x), transform(y))
}