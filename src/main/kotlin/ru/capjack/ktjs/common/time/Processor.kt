package ru.capjack.ktjs.common.time

abstract class Processor {
	protected var active: Boolean = false
		private set
	
	fun start() {
		if (!active) {
			active = true
			doStart()
		}
	}
	
	fun stop() {
		if (active) {
			active = false
			doStop()
		}
	}
	
	abstract fun doStart()
	
	abstract fun doStop()
	
	abstract fun clear()
}
