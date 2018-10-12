package ru.capjack.ktjs.common

import ru.capjack.ktjs.common.Delegates.observable

open class MutableChangeableValueImpl<V>(value: V) : MutableChangeableValue<V>, Destroyable {
	private var handlers = ProcedureGroup()
	
	override var value: V by observable(value) { v ->
		handlers.invoke(v)
	}
	
	override fun onChange(handler: (V) -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun onChange(handler: () -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun offChange(handler: () -> Unit) {
		handlers.remove(handler)
	}
	
	override fun offChange(handler: (V) -> Unit) {
		handlers.remove(handler)
	}
	
	override fun destroy() {
		handlers.clear()
	}
}