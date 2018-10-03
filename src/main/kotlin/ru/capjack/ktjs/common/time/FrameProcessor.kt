package ru.capjack.ktjs.common.time

import kotlin.browser.window

internal open class FrameProcessor : Processor() {
	private val tasks: MutableList<FrameTask> = mutableListOf()
	private val newTasks: MutableList<FrameTask> = mutableListOf()
	
	private var processing: Boolean = false
	private var tickerActive = false
	private var tickerLastTickTime: Double = 0.0
	private var tickerStopPassedTime: Double = 0.0
	private var tickerId: Int = 0
	
	override fun doStart() {
		if (tasks.isNotEmpty()) {
			startTicker()
		}
	}
	
	override fun doStop() {
		stopTicker()
	}
	
	override fun clear() {
		tasks.forEach(FrameTask::cancel)
		tasks.clear()
		
		newTasks.forEach(FrameTask::cancel)
		newTasks.clear()
	}
	
	fun addTask(repeatable: Boolean, handler: (Double) -> Unit): FrameTask {
		val task = FrameTask(repeatable, handler)
		if (processing) {
			newTasks.add(task)
		}
		else {
			tasks.add(task)
			if (active) {
				startTicker()
			}
		}
		return task
	}
	
	private fun tick() {
		if (processing) {
			throw IllegalStateException()
		}
		processing = true
		
		val currentTime = defineCurrentTime()
		val passedTime = currentTime - tickerLastTickTime
		tickerLastTickTime = currentTime
		
		val iterator = tasks.listIterator()
		
		while (iterator.hasNext()) {
			val task = iterator.next()
			
			try {
				task.tick(passedTime)
			}
			catch (error: Throwable) {
				stop()
				throw error
			}
			
			if (!task.alive) {
				iterator.remove()
			}
		}
		
		if (newTasks.isNotEmpty()) {
			tasks.addAll(newTasks)
			newTasks.clear()
		}
		
		if (tasks.isEmpty()) {
			stopTicker()
		}
		processing = false
	}
	
	private fun startTicker() {
		if (!tickerActive) {
			tickerActive = true
			tickerLastTickTime = defineCurrentTime() - tickerStopPassedTime
			requestAnimationFrame()
		}
	}
	
	private fun stopTicker() {
		if (tickerActive) {
			tickerActive = false
			tickerStopPassedTime = defineCurrentTime() - tickerLastTickTime
			window.cancelAnimationFrame(tickerId)
		}
	}
	
	private fun requestAnimationFrame() {
		tickerId = window.requestAnimationFrame {
			tick()
			if (tickerActive) {
				requestAnimationFrame()
			}
		}
	}
}
