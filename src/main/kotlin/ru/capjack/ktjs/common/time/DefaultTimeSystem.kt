package ru.capjack.ktjs.common.time

import ru.capjack.ktjs.common.Cancelable

class DefaultTimeSystem : TimeSystem {
	private val frameProcessor = FrameProcessor()
	private val scheduledProcessor = ScheduledProcessor()
	
	private var active: Boolean = false
	
	override fun isActive(): Boolean = active
	
	override fun start() {
		if (!active) {
			active = true
			frameProcessor.start()
			scheduledProcessor.start()
		}
	}
	
	override fun stop() {
		if (active) {
			active = false
			frameProcessor.stop()
			scheduledProcessor.stop()
		}
	}
	
	override fun clear() {
		frameProcessor.clear()
		scheduledProcessor.clear()
	}
	
	override fun forNextFrame(handler: (passedTime: Double) -> Unit): Cancelable {
		return frameProcessor.addTask(false, handler)
	}
	
	override fun forEachFrame(handler: (passedTime: Double) -> Unit): Cancelable {
		return frameProcessor.addTask(true, handler)
	}
	
	override fun schedule(delay: Int, handler: (passedTime: Double) -> Unit): Cancelable {
		return scheduledProcessor.addTask(false, delay, handler)
	}
	
	override fun scheduleRepeatable(delay: Int, handler: (passedTime: Double) -> Unit): Cancelable {
		return scheduledProcessor.addTask(true, delay, handler)
	}
	
}

