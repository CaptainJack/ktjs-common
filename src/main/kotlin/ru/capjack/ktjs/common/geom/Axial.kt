package ru.capjack.ktjs.common.geom

interface Axial<T> {
	val x: T
	val y: T
	
	operator fun get(axis: Axis): T
}