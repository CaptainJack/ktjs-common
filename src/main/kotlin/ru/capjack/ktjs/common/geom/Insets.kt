package ru.capjack.ktjs.common.geom

interface Insets<T : Number> {
	val left: T
	val right: T
	val top: T
	val bottom: T
	
	val size: Axial<T>
	val leftTop: Axial<T>
}