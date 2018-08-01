package ru.capjack.ktjs.common

// Randoms

fun <T> List<T>.random() = get(randomIndex())

fun List<*>.randomIndex() = Random.makeInt(this.size)


fun <T> Array<T>.random() = get(randomIndex())

fun Array<*>.randomIndex() = Random.makeInt(this.size)


fun BooleanArray.random() = get(randomIndex())

fun BooleanArray.randomIndex() = Random.makeInt(this.size)


fun ByteArray.random() = get(randomIndex())

fun ByteArray.randomIndex() = Random.makeInt(this.size)


fun IntArray.random() = get(randomIndex())

fun IntArray.randomIndex() = Random.makeInt(this.size)


fun LongArray.random() = get(randomIndex())

fun LongArray.randomIndex() = Random.makeInt(this.size)


fun DoubleArray.random() = get(randomIndex())

fun DoubleArray.randomIndex() = Random.makeInt(this.size)
