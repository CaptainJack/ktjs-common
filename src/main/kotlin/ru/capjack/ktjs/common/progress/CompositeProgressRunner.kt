package ru.capjack.ktjs.common.progress

open class CompositeProgressRunner(private val runners: Collection<ProgressRunner>) : ProgressRunner {
	
	constructor(vararg runners: ProgressRunner) : this(runners.toList())
	
	override fun run(): Progress {
		val progresses = runners.map { it.run() }
		return CompositeProgress(progresses)
	}
}