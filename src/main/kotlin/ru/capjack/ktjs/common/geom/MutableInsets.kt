package ru.capjack.ktjs.common.geom

interface MutableInsets<T : Number> : Insets<T> {
	override var left: T
	override var right: T
	override var top: T
	override var bottom: T
}