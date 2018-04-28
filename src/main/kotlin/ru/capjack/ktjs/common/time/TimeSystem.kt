package ru.capjack.ktjs.common.time

import ru.capjack.ktjs.common.Cancelable

interface TimeSystem {
	fun isActive(): Boolean
	
	fun start()
	
	fun stop()
	
	fun clear()
	
	fun onNextFrame(handler: (passedTime: Double) -> Unit): Cancelable
	
	fun onEachFrame(handler: (passedTime: Double) -> Unit): Cancelable
	
	fun schedule(delay: Int, handler: (passedTime: Double) -> Unit): Cancelable
	
	fun scheduleRepeatable(delay: Int, handler: (passedTime: Double) -> Unit): Cancelable
}