package ru.capjack.ktjs.common

interface MutableConfines<T> : Confines<T> {
	override var min: T
	override var max: T
}