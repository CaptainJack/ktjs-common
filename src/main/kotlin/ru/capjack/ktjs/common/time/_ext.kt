package ru.capjack.ktjs.common.time

import ru.capjack.ktjs.common.Cancelable

inline fun TimeSystem.onNextFrame(crossinline handler: () -> Unit): Cancelable {
	return onNextFrame { _ -> handler() }
}

inline fun TimeSystem.onEachFrame(crossinline handler: () -> Unit): Cancelable {
	return onEachFrame { _ -> handler() }
}

inline fun TimeSystem.schedule(delay: Int, crossinline handler: () -> Unit): Cancelable {
	return schedule(delay) { _ -> handler() }
}

inline fun TimeSystem.scheduleRepeatable(delay: Int, crossinline handler: () -> Unit): Cancelable {
	return scheduleRepeatable(delay) { _ -> handler() }
}