package ru.capjack.ktjs.common.geom

enum class Axis {
	HORIZONTAL,
	VERTICAL;
	
	companion object {
		inline fun forEach(block: (axis: Axis) -> Unit) {
			block(HORIZONTAL)
			block(VERTICAL)
		}
	}
	
	val opposite: Axis
		get() = if (this == HORIZONTAL) VERTICAL else HORIZONTAL
}