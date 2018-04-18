package ru.capjack.ktjs.common.events

import ru.capjack.ktjs.common.Cancelable
import kotlin.reflect.KClass

interface EventDealer<in E : Any> {
	fun <C : E> addEventReceiver(type: KClass<C>, receiver: () -> Unit): Cancelable
	
	fun <C : E> addEventReceiver(type: KClass<C>, receiver: (event: C) -> Unit): Cancelable
	
	fun <C : E> addEventReceiver(type: C, receiver: () -> Unit): Cancelable
	
	fun <C : E> addEventReceiver(type: C, receiver: (event: C) -> Unit): Cancelable
}