package ru.capjack.ktjs.common

class ProcedureGroup {
	private val holders: MutableList<Holder> = mutableListOf()
	
	fun clear() {
		holders.clear()
	}
	
	fun add(procedure: Function<Unit>): Cancelable = doAdd(procedure)
	
	fun remove(procedure: Function<Unit>): Boolean = doRemove(procedure)
	
	fun invoke(vararg args: Any?) = doInvoke(args)
	
	fun invoke(args: Array<out Any?>) = doInvoke(args)
	
	fun clearAndInvoke(vararg args: Any?) = doClearAndInvoke(args)
	
	fun clearAndInvoke(args: Array<out Any?>) = doClearAndInvoke(args)
	
	private fun doAdd(procedure: dynamic): Cancelable {
		val holder = Holder(procedure)
		holders.add(holder)
		return holder
	}
	
	private fun doRemove(procedure: dynamic): Boolean {
		val iterator = holders.listIterator()
		while (iterator.hasNext()) {
			if (iterator.next().has(procedure)) {
				iterator.remove()
				return true
			}
		}
		return false
	}
	
	private fun doInvoke(args: Array<out Any?>) {
		for (holder in holders) {
			holder.invoke(args)
		}
	}
	
	private fun doClearAndInvoke(args: Array<out Any?>) {
		val list = holders.toTypedArray()
		clear()
		for (holder in list) {
			holder.invoke(args)
		}
	}
	
	private inner class Holder(private val procedure: dynamic) : Cancelable {
		
		override fun cancel() {
			holders.remove(this)
		}
		
		fun has(function: dynamic): Boolean {
			return this.procedure === function
		}
		
		fun invoke(args: Array<out Any?>) {
			procedure.apply(null, args)
		}
	}
}