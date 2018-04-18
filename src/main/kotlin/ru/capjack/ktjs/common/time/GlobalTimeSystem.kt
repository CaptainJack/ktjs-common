package ru.capjack.ktjs.common.time

object GlobalTimeSystem : TimeSystem by DefaultTimeSystem() {
	init {
		start()
	}
}