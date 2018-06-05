package ru.capjack.ktjs.common.geom

class MutableIntInsets(
	override var left: Int,
	override var right: Int,
	override var top: Int,
	override var bottom: Int
) : MutableInsets<Int> {
	
	constructor(both: Int) : this(both, both)
	
	constructor(x: Int, y: Int) : this(x, x, y, y)
	
	override fun set(left: Int, right: Int, top: Int, bottom: Int) {
		this.left = left
		this.right = right
		this.top = top
		this.bottom = bottom
	}
	
	override val size: Axial<Int>
		get() = axial(left + right, top + bottom)
	
	override val leftTop: Axial<Int>
		get() = axial(left, top)
}