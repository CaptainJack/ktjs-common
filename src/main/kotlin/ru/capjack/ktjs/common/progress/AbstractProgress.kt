package ru.capjack.ktjs.common.progress

import ru.capjack.ktjs.common.Cancelable
import ru.capjack.ktjs.common.ProcedureGroup
import ru.capjack.ktjs.common.invokeDelayed

abstract class AbstractProgress : Progress {
	final override var completed = false
		private set
	
	override val percent: Double
		get() = if (completed) 1.0 else calculatePercent()
	
	private val completeHandlers = ProcedureGroup()
	
	protected abstract fun calculatePercent(): Double
	
	protected open fun doComplete() {}
	
	protected fun complete() {
		if (!completed) {
			completed = true
			doComplete()
			invokeCompleteHandlers()
		}
	}
	
	override fun onComplete(handler: () -> Unit): Cancelable {
		val task = completeHandlers.add(handler)
		if (completed) {
			invokeDelayed(::invokeCompleteHandlers)
		}
		return task
	}
	
	private fun invokeCompleteHandlers() {
		completeHandlers.clearAndInvoke()
	}
}