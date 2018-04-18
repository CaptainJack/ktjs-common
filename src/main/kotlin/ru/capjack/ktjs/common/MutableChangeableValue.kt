package ru.capjack.ktjs.common

interface MutableChangeableValue<V> : ChangeableValue<V> {
	override var value: V
}