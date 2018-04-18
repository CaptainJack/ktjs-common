package ru.capjack.ktjs.common.time

import ru.capjack.ktjs.common.Cancelable

interface TimeSystem {
	fun isActive(): Boolean
	
	fun start()
	
	fun stop()
	
	fun clear()
	
	fun forNextFrame(handler: (passedTime: Double) -> Unit): Cancelable
	
	fun forEachFrame(handler: (passedTime: Double) -> Unit): Cancelable
	
	fun schedule(delay: Int, handler: (passedTime: Double) -> Unit): Cancelable
	
	fun scheduleRepeatable(delay: Int, handler: (passedTime: Double) -> Unit): Cancelable
}