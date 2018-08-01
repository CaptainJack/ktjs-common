package ru.capjack.ktjs.common

// Replaces

fun <T> T.replaceIf(eq: T, to: T): T {
	return if (this == eq) to else this
}

fun <T> T.replaceIf(condition: Boolean, to: T): T {
	return if (condition) to else this
}

inline fun <T> T.replaceIf(condition: Boolean, to: (T) -> T): T {
	return if (condition) to(this) else this
}

inline fun <T> T.replaceIf(condition: () -> Boolean, to: T): T {
	return if (condition()) to else this
}

inline fun <T> T.replaceIf(condition: () -> Boolean, to: (T) -> T): T {
	return if (condition()) to(this) else this
}

fun <T : Comparable<T>> T.replaceIfLess(value: T, to: T): T {
	return if (this < value) to else this
}

fun <T : Comparable<T>> T.replaceIfGreat(value: T, to: T): T {
	return if (this > value) to else this
}