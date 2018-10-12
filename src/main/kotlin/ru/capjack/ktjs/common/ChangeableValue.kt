package ru.capjack.ktjs.common

interface ChangeableValue<out V> : Changeable {
	val value: V
	
	fun onChange(handler: (V) -> Unit): Cancelable
	
	fun offChange(handler: (V) -> Unit)
}