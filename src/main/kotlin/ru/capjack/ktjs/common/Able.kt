package ru.capjack.ktjs.common

interface Able {
	var enabled: Boolean
	
	fun enable() {
		enabled = true
	}
	
	fun disable() {
		enabled = false
	}
}