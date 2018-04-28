package ru.capjack.ktjs.common.progress

import ru.capjack.ktjs.common.Cancelable
import ru.capjack.ktjs.common.CancelableDummy
import ru.capjack.ktjs.common.invokeDelayedCancelable

class FakeProgress(override val completed: Boolean) : Progress {
	companion object {
		val COMPLETED: Progress = FakeProgress(true)
		val NOT_COMPLETED: Progress = FakeProgress(false)
	}
	
	override val percent: Double = if (completed) 1.0 else 0.0
	
	override fun onComplete(handler: () -> Unit): Cancelable {
		return if (completed) invokeDelayedCancelable(handler) else CancelableDummy
	}
}

