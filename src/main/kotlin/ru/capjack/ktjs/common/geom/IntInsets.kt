package ru.capjack.ktjs.common.geom

class IntInsets(
	override val left: Int,
	override val right: Int,
	override val top: Int,
	override val bottom: Int
) : Insets<Int> {
	
	override val horizontal: Int = left + right
	
	override val vertical: Int = top + bottom
	
	constructor(both: Int) : this(both, both)
	
	constructor(horizontal: Int, vertical: Int) : this(horizontal, horizontal, vertical, vertical)
}