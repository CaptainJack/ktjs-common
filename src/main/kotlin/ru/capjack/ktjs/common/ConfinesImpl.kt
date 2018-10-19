package ru.capjack.ktjs.common

class ConfinesImpl<T>(override val min: T, override val max: T = min) : Confines<T>

fun <T> confines(min: T, max: T = min): Confines<T> {
	return ConfinesImpl(min, max)
}