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