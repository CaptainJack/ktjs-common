package ru.capjack.ktjs.common.time

import kotlin.browser.window

internal class ScheduledTask(
	private val processor: ScheduledProcessor,
	repeatable: Boolean,
	private val delay: Int,
	private val handler: (Double) -> Unit

) : Task(repeatable) {
	
	private var startTime: Double = 0.0
	private var tickId: Int? = null
	
	override fun doCancel() {
		if (tickId != null) {
			if (repeatable) {
				window.clearInterval(tickId!!)
			}
			else {
				window.clearTimeout(tickId!!)
			}
			tickId = null
		}
		processor.removeTask(this)
	}
	
	fun start() {
		startTime = window.performance.now()
		
		tickId = if (repeatable) {
			window.setInterval(::tick, delay)
		}
		else {
			window.setTimeout(::tick, delay)
		}
	}
	
	private fun tick() {
		val now = window.performance.now()
		handler(now - startTime)
		
		if (repeatable) {
			startTime = now
		}
		else {
			tickId = null
			cancel()
		}
	}
}