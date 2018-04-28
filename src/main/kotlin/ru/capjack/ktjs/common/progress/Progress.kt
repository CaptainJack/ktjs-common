package ru.capjack.ktjs.common.progress

import ru.capjack.ktjs.common.Cancelable

interface Progress {
	val completed: Boolean
	val percent: Double
	
	fun onComplete(handler: () -> Unit): Cancelable
}