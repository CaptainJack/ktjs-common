package ru.capjack.ktjs.common

class Handlers {
	private val holders: MutableList<Holder> = mutableListOf()
	
	fun add(handler: () -> Unit): Cancelable {
		return add(FunctionHolder(handler))
	}
	
	fun add(handler: Handler): Cancelable {
		return add(HandlerHolder(handler))
	}
	
	private fun add(holder: Holder): Holder {
		holders.add(holder)
		return holder
	}
	
	fun remove(handler: Handler): Boolean {
		val iterator = holders.listIterator()
		while (iterator.hasNext()) {
			if (iterator.next().isPresentHandler(handler)) {
				iterator.remove()
				return true
			}
		}
		return false
	}
	
	fun invoke() {
		for (holder in holders) {
			holder.invoke()
		}
	}
	
	fun clearAndInvoke() {
		val list = holders.toTypedArray()
		clear()
		for (holder in list) {
			holder.invoke()
		}
	}
	
	fun clear() {
		holders.clear()
	}
	
	private inner abstract class Holder : Cancelable {
		
		override fun cancel() {
			holders.remove(this)
		}
		
		abstract fun invoke()
		
		abstract fun isPresentHandler(handler: Handler): Boolean
		
	}
	
	private inner class FunctionHolder(val handler: () -> Unit) : Holder() {
		override fun invoke() {
			handler.invoke()
		}
		
		override fun isPresentHandler(handler: Handler): Boolean {
			return false
		}
	}
	
	private inner class HandlerHolder(val handler: Handler) : Holder() {
		override fun invoke() {
			handler.invoke()
		}
		
		override fun isPresentHandler(handler: Handler): Boolean {
			return this.handler == handler
		}
	}
}