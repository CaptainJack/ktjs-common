package ru.capjack.ktjs.common.progress

open class EmptyProgress : AbstractProgress() {
	override fun calculatePercent() = 0.0
	
	fun makeComplete() {
		complete()
	}
}