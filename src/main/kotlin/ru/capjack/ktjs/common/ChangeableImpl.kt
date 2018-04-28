package ru.capjack.ktjs.common

open class ChangeableImpl : Changeable, Destroyable {
	private var handlers = ProcedureGroup()
	
	override fun onChange(handler: () -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun destroy() {
		handlers.clear()
	}
	
	protected open fun dispatchChange() {
		handlers.invoke()
	}
}