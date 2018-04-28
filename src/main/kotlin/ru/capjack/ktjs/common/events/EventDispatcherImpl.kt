package ru.capjack.ktjs.common.events

import ru.capjack.ktjs.common.Cancelable
import ru.capjack.ktjs.common.ProcedureGroupMap
import kotlin.reflect.KClass

open class EventDispatcherImpl<in E : Any> : EventDispatcher<E> {
	private val receivers = ProcedureGroupMap<Any>()
	
	override fun introduceEvent(event: E) {
		receivers.invoke(event::class, event)
		receivers.invoke(event, event)
	}
	
	override fun <C : E> onEvent(type: KClass<C>, receiver: () -> Unit) = addReceiver(type, receiver)
	
	override fun <C : E> onEvent(type: KClass<C>, receiver: (event: C) -> Unit) = addReceiver(type, receiver)
	
	override fun <C : E> onEvent(type: C, receiver: () -> Unit) = addReceiver(type, receiver)
	
	override fun <C : E> onEvent(type: C, receiver: (event: C) -> Unit) = addReceiver(type, receiver)
	
	fun clearEventReceivers() {
		receivers.clear()
	}
	
	private fun addReceiver(type: Any, handler: Function<Unit>): Cancelable {
		return receivers.add(type, handler)
	}
}