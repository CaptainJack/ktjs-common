package ru.capjack.ktjs.common

class HandlerOfFunction(private val fn: () -> Unit) : Handler {
	override fun invoke() {
		fn.invoke()
	}
}