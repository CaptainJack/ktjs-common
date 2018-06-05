package ru.capjack.ktjs.common.geom

fun <T : Number> MutableInsets<T>.set(left: T, right: T, top: T, bottom: T) {
	this.left = left
	this.right = right
	this.top = top
	this.bottom = bottom
}

fun <T : Number> MutableInsets<T>.set(x: T, y: T) {
	set(x, x, y, y)
}

fun <T : Number> MutableInsets<T>.set(both: T) {
	set(both, both)
}