package ru.capjack.ktjs.common.geom

interface MutableInsets<T : Number> : Insets<T>, MutableAxialValues<T> {
	override var left: T
	override var right: T
	override var top: T
	override var bottom: T
	
	fun set(left: T, right: T, top: T, bottom: T)
}