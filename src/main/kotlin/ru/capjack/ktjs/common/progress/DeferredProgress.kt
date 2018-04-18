package ru.capjack.ktjs.common.progress

open class DeferredProgress : AbstractProgress() {
	
	private var progress: Progress? = null
	
	fun run(progress: Progress) {
		if (this.progress != null) {
			throw IllegalStateException()
		}
		this.progress = progress
		progress.addCompleteHandler(::complete)
	}
	
	override fun calculatePercent(): Double {
		return progress?.percent ?: 0.0
	}
}