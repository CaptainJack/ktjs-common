package ru.capjack.ktjs.common.geom

open class MutableChangeableAxialImpl<T>(x: T, y: T) : ChangeableAxialImpl<T>(x, y), MutableChangeableAxial<T>