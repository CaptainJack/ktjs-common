package ru.capjack.ktjs.common

import kotlin.browser.window
import kotlin.properties.Delegates

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


inline fun <T> observable(initialValue: T, crossinline onChange: (newValue: T) -> Unit) =
	Delegates.observable(initialValue) { _, _, newValue -> onChange(newValue) }

inline fun <T> observable(initialValue: T, crossinline onChange: () -> Unit) =
	Delegates.observable(initialValue) { _, _, _ -> onChange() }
