package ru.capjack.ktjs.common

interface FlowNumber<T : Number> {
	val current: T
	
	fun addHandler(handler: (current: T, delta: T) -> Unit): Cancelable
	
	fun seek(value: T)
	
	fun set(value: T)
}