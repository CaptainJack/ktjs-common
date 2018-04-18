package ru.capjack.ktjs.common

class MutableConfinesImpl<T>(override var min: T, override var max: T = min) : MutableConfines<T>