package ru.capjack.ktjs.common

abstract class AbstractChangeable<T> : Changeable<T>, Destroyable {
	private var handlers = ProcedureGroup()
	
	protected open fun introduceChange(value: T) {
		handlers.invoke(value)
	}
	
	override fun onChange(handler: () -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun onChange(handler: (T) -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun offChange(handler: () -> Unit) {
		handlers.remove(handler)
	}
	
	override fun offChange(handler: (T) -> Unit) {
		handlers.remove(handler)
	}
	
	override fun destroy() {
		handlers.clear()
	}
}

