package ru.capjack.ktjs.common.time

class FrameTask(
	repeatable: Boolean,
	private val closure: (Double) -> Unit

) : Task(repeatable) {
	fun tick(passedTime: Double) {
		if (alive) {
			closure(passedTime)
			if (!repeatable) {
				cancel()
			}
		}
	}
	
	override fun doCancel() {}
}