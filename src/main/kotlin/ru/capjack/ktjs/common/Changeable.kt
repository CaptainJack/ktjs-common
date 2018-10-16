package ru.capjack.ktjs.common

interface Changeable<out T> {
	fun onChange(handler: () -> Unit): Cancelable
	
	fun onChange(handler: (T) -> Unit): Cancelable
	
	fun offChange(handler: () -> Unit)
	
	fun offChange(handler: (T) -> Unit)
}