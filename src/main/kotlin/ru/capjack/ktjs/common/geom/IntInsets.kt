package ru.capjack.ktjs.common.geom

class IntInsets(
	override val left: Int,
	override val right: Int,
	override val top: Int,
	override val bottom: Int
) : Insets<Int> {
	
	constructor(both: Int) : this(both, both)
	
	constructor(x: Int, y: Int) : this(x, x, y, y)
	
	override val size: AxialValues<Int>
		get() = axial(left + right, top + bottom)
	
	override val leftTop: AxialValues<Int>
		get() = axial(left, top)
}