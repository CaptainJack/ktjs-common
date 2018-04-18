package ru.capjack.ktjs.common.progress

class SequentialProgress(private val runners: List<ProgressRunner>) : AbstractProgress() {
	private var currentIndex: Int = -1
	private lateinit var currentProgress: Progress
	
	constructor(vararg runners: ProgressRunner) : this(runners.toList())
	
	init {
		runNext()
	}
	
	override fun calculatePercent(): Double {
		return (currentIndex + currentProgress.percent) / runners.size
	}
	
	private fun runNext() {
		++currentIndex
		if (currentIndex == runners.size) {
			complete()
		}
		else {
			currentProgress = runners[currentIndex].run()
			currentProgress.addCompleteHandler(::runNext)
		}
	}
}