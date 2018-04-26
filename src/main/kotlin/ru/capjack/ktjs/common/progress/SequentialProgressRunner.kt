package ru.capjack.ktjs.common.progress

open class SequentialProgressRunner(private val runners: List<ProgressRunner>) : ProgressRunner {
	constructor(vararg runners: ProgressRunner) : this(runners.toList())
	
	override fun run(): Progress {
		return SequentialProgress(runners)
	}
}