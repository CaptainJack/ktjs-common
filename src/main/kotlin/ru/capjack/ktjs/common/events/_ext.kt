package ru.capjack.ktjs.common.events

import ru.capjack.ktjs.common.Cancelable

inline fun <reified C : Any> EventDealer<C>.onEvent(noinline receiver: () -> Unit): Cancelable {
	return onEvent(C::class, receiver)
}

inline fun <reified C : Any> EventDealer<C>.onEvent(noinline receiver: (event: C) -> Unit): Cancelable {
	return onEvent(C::class, receiver)
}
