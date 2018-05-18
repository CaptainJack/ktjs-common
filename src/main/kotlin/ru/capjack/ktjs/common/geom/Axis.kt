package ru.capjack.ktjs.common.geom

enum class Axis {
	X, Y;
	
	companion object {
		inline fun forEach(block: (axis: Axis) -> Unit) {
			block(X)
			block(Y)
		}
	}
	
	val opposite: Axis
		get() = if (this == X) Y else X
}