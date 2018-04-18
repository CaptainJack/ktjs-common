package ru.capjack.ktjs.common

open class ChangeableImpl : Changeable, Destroyable {
	private var handlers: Handlers = Handlers()
	
	override fun addChangeHandler(handler: () -> Unit): Cancelable {
		return handlers.add(handler)
	}
	
	override fun addChangeHandler(handler: Handler): Cancelable {
		return handlers.add(handler)
	}
	
	override fun removeChangeHandler(handler: Handler): Boolean {
		return handlers.remove(handler)
	}
	
	override fun destroy() {
		handlers.clear()
	}
	
	protected open fun dispatchChange() {
		handlers.invoke()
	}
}