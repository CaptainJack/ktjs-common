package ru.capjack.ktjs.common.math

fun <T> List<T>.random(): T {
	return Random.take(this)
}

fun List<*>.randomIndex(): Int {
	return Random.make(this.size)
}