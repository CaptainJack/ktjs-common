package ru.capjack.ktjs.common

interface NumberFlow<T : Number> {
	val current: T
	
	fun onChange(handler: (current: T, delta: T) -> Unit): Cancelable
	
	fun onChange(handler: (current: T) -> Unit): Cancelable
	
	fun onChange(handler: () -> Unit): Cancelable
	
	fun seek(value: T)
	
	fun set(value: T)
}