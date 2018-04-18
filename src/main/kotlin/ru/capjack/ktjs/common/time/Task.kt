package ru.capjack.ktjs.common.time

import ru.capjack.ktjs.common.Cancelable

abstract class Task(
	protected val repeatable: Boolean

) : Cancelable {
	
	var alive: Boolean = true
		private set
	
	override fun cancel() {
		if (alive) {
			alive = false
			doCancel()
		}
	}
	
	abstract fun doCancel()
}