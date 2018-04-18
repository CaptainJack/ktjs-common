package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.math.Random

// Collections

inline fun <T, reified R> Array<T>.mapToArray(transform: (T) -> R): Array<R> {
    return Array(size) { transform(this[it]) }
}

inline fun <reified T> Array<T>.cutLast(n: Int): Array<T> {
    require(n >= 0) { "Requested element count $n is less than zero." }

    return when {
        n == 0 -> this
        n == size -> emptyArray()
        n > size -> throw IllegalArgumentException()
        else -> Array(this.size - n) { this[it] }
    }
}


// Randoms

fun <T> Array<T>.getRandomElement(): T {
    return get(Random.make(size))
}

// Nulls

inline fun <T> T?.ifNotNull(block: (T) -> Unit) {
    val t = this
    if (t != null) {
        block(t)
    }
}


// Replaces

fun <T> T.replaceIf(eq: T, to: T): T {
    return if (this == eq) to else this
}

fun <T> T.replaceIf(condition: Boolean, to: T): T {
    return if (condition) to else this
}

fun <T> T.replaceIf(condition: Boolean, to: (T) -> T): T {
    return if (condition) to(this) else this
}

fun <T : Comparable<T>> T.replaceIfLess(value: T, to: T): T {
    return if (this < value) to else this
}

fun <T : Comparable<T>> T.replaceIfGreat(value: T, to: T): T {
    return if (this > value) to else this
}


// Numbers

inline fun Int.repeat(from: Int = 0, block: (i: Int) -> Unit) {
    (from until this).forEach(block)
}

fun Double.replaceIfNotFinite(to: Double): Double {
    return if (this.isFinite()) this else to
}

fun Double.toStringFormatted(thousandsSeparator: String = " ", fractionDigits: Int = 2): String {
    @Suppress("UnsafeCastFromDynamic")
    val str: String = asDynamic().toFixed(fractionDigits)

    return when (fractionDigits) {
        0 -> formatNumberString(str, 3, thousandsSeparator)
        else -> formatNumberString(str, 4 + fractionDigits, thousandsSeparator)
    }
}

fun Number.toStringFormatted(thousandsSeparator: String = " "): String {
    return formatNumberString(toString(), 3, thousandsSeparator)
}

private fun formatNumberString(str: String, start: Int, thousandsSeparator: String): String {
    var s = str
    if (thousandsSeparator.isNotEmpty()) {
        val f = if (str[0] == '-') 1 else 0
        var i = str.length - start
        while (i > f) {
            s = s.insert(i, thousandsSeparator)
            i -= 3
        }
    }
    return s
}


// Strings

fun CharSequence.insert(position: Int, insertion: String, deleteLength: Int = 0): String {
    return substring(0, position) + insertion + substring(position + deleteLength)
}

fun String.format(vararg args: Any): String {
    return format(args.toList())
}

fun String.format(args: List<Any>): String {
    var string = this
    for (arg in args) {
        string = string.replaceFirst("{}", arg.toString())
    }
    return string
}
