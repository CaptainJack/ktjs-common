package ru.capjack.ktjs.common.progress

inline fun progress(init: ControllableProgress.() -> Unit): Progress {
	return ControllableProgress().apply(init)
}


inline fun progressRunner(crossinline runner: () -> Progress): ProgressRunner {
	return object : ProgressRunner {
		override fun run() = runner()
	}
}

fun progressRunner(vararg runners: () -> Progress): ProgressRunner {
	return CompositeProgressRunner(runners.map(::progressRunner))
}

fun progressRunner(vararg runners: ProgressRunner): ProgressRunner {
	return CompositeProgressRunner(*runners)
}

fun sequentialProgressRunner(vararg runners: ProgressRunner): ProgressRunner {
	return SequentialProgressRunner(*runners)
}

fun sequentialProgressRunner(vararg runners: () -> Progress): ProgressRunner {
	return SequentialProgressRunner(runners.map(::progressRunner))
}