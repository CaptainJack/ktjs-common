package ru.capjack.ktjs.common.time

import ru.capjack.ktjs.common.Cancelable

internal class ScheduledProcessor : Processor() {
	private val tasks: MutableList<ScheduledTask> = mutableListOf()
	
	override fun doStart() {
		tasks.forEach(ScheduledTask::start)
	}
	
	override fun doStop() {
		clear()
	}
	
	override fun clear() {
		val copy = tasks.toTypedArray()
		tasks.clear()
		copy.forEach(ScheduledTask::cancel)
	}
	
	fun addTask(repeatable: Boolean, delay: Int, handler: (Double) -> Unit): Cancelable {
		val task = ScheduledTask(this, repeatable, delay, handler)
		tasks.add(task)
		if (active) {
			task.start()
		}
		return task
	}
	
	fun removeTask(task: ScheduledTask) {
		tasks.remove(task)
	}
}
