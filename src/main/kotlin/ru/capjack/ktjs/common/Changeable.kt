package ru.capjack.ktjs.common

interface Changeable {
	fun addChangeHandler(handler: () -> Unit): Cancelable
	
	fun addChangeHandler(handler: Handler): Cancelable
	
	fun removeChangeHandler(handler: Handler): Boolean
}