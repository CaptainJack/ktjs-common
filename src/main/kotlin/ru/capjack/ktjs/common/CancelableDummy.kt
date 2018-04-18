package ru.capjack.ktjs.common

object CancelableDummy : Cancelable {
	override fun cancel() {}
}