package ru.capjack.ktjs.common

class ConfinesImpl<out T>(override val min: T, override val max: T = min) : Confines<T>