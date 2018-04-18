package ru.capjack.ktjs.common

open class MutableChangeableValueImpl<V>(value: V) : ChangeableImpl(), MutableChangeableValue<V> {
	override var value: V by observable(value, ::dispatchChange)
}