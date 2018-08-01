package ru.capjack.ktjs.common

import kotlin.browser.window

fun invokeDelayed(fn: () -> Unit) {
	window.setTimeout(fn, 1)
}

fun invokeDelayedCancelable(fn: () -> Unit): Cancelable {
	val timeoutId = window.setTimeout(fn, 1)
	return object : Cancelable {
		override fun cancel() {
			window.clearTimeout(timeoutId)
		}
	}
}

