package ru.capjack.ktjs.common.geom

fun <T : Number> MutableInsets<T>.set(x: T, y: T) {
	left = x
	right = x
	top = y
	bottom = y
}

fun <T : Number> MutableInsets<T>.set(both: T) {
	set(both, both)
}