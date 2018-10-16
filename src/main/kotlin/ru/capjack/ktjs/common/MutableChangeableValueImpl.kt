package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.Delegates.observable

open class MutableChangeableValueImpl<V>(value: V) : AbstractChangeable<V>(), MutableChangeableValue<V> {
	override var value: V by observable(value) { v ->
		introduceChange(v)
	}
}