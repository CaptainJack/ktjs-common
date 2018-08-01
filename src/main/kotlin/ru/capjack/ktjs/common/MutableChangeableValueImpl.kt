package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.Delegates.observable

open class MutableChangeableValueImpl<V>(value: V) : ChangeableImpl(), MutableChangeableValue<V> {
	override var value: V by observable(value, ::dispatchChange)
}