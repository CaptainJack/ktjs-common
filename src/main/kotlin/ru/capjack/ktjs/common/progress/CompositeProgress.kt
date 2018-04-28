package ru.capjack.ktjs.common.progress

import ru.capjack.ktjs.common.invokeDelayed

open class CompositeProgress(private val progresses: Collection<Progress>) : AbstractProgress() {
	
	constructor(vararg progresses: Progress) : this(progresses.toList())
	
	init {
		if (progresses.isEmpty()) {
			invokeDelayed(::complete)
		}
		else {
			var completedCount = 0
			for (progress in progresses) {
				if (progress.completed) {
					++completedCount
				}
				else {
					progress.onComplete(::handleProgressCompleted)
				}
			}
			if (completedCount == progresses.size) {
				invokeDelayed(::complete)
			}
		}
	}
	
	override fun calculatePercent(): Double {
		val total: Double = progresses.sumByDouble { it.percent }
		return total / progresses.size
	}
	
	private fun handleProgressCompleted() {
		if (progresses.all { it.completed }) {
			complete()
		}
	}
}