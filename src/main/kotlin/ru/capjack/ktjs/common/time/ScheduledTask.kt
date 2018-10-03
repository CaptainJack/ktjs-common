package ru.capjack.ktjs.common.time

import kotlin.browser.window

internal class ScheduledTask(
	private val processor: ScheduledProcessor,
	repeatable: Boolean,
	private val delay: Int,
	private val handler: (Double) -> Unit

) : Task(repeatable) {
	
	private var startTime: Double = 0.0
	private var stopPassedTime: Double = 0.0
	private var tickId: Int? = null
	
	override fun doCancel() {
		if (tickId != null) {
			stopTicker()
		}
		processor.removeTask(this)
	}
	
	fun start() {
		startTime = defineCurrentTime() - stopPassedTime
		if (stopPassedTime == 0.0) {
			startTicker()
		}
		else {
			tickId = window.setTimeout(::tick, (delay - stopPassedTime).toInt())
		}
	}
	
	fun stop() {
		if (tickId != null) {
			stopTicker()
			stopPassedTime = defineCurrentTime() - startTime
		}
	}
	
	private fun tick() {
		val now = defineCurrentTime()
		handler(now - startTime)
		
		if (repeatable) {
			if (stopPassedTime == 0.0) {
				startTime = now
			}
			else {
				stopPassedTime = 0.0
				startTicker()
			}
		}
		else {
			tickId = null
			cancel()
		}
	}
	
	private fun startTicker() {
		tickId = if (repeatable) {
			window.setInterval(::tick, delay)
		}
		else {
			window.setTimeout(::tick, delay)
		}
	}
	
	private fun stopTicker() {
		if (repeatable) {
			window.clearInterval(tickId!!)
		}
		else {
			window.clearTimeout(tickId!!)
		}
		tickId = null
	}
	
}