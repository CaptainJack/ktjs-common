package ru.capjack.ktjs.common

interface Changeable {
	fun onChange(handler: () -> Unit): Cancelable
}