package ru.capjack.ktjs.common

import kotlin.browser.window
import kotlin.properties.ReadWriteProperty

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


fun <T> observable(initialValue: T, onChange: (newValue: T) -> Unit): ReadWriteProperty<Any?, T> {
	return CorrectObservableProperty(initialValue, onChange)
}

fun <T> observable(initialValue: T, onChange: () -> Unit): ReadWriteProperty<Any?, T> {
	return CorrectObservableProperty(initialValue, { _ -> onChange() })
}


