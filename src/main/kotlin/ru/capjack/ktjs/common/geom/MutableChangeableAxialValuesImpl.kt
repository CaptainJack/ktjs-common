package ru.capjack.ktjs.common.geom

open class MutableChangeableAxialValuesImpl<T>(x: T, y: T) : ChangeableAxialValuesImpl<T>(x, y), MutableChangeableAxialValues<T>