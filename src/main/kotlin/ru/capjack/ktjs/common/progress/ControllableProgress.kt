package ru.capjack.ktjs.common.progress

open class ControllableProgress() : AbstractProgress() {
	override fun calculatePercent() = 0.0
	
	fun makeComplete() {
		complete()
	}
}