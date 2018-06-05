package ru.capjack.ktjs.common.geom

class IntRectangle(
	x: Int,
	y: Int,
	width: Int,
	height: Int
) : Rectangle<Int> {
	
	override val position: Axial<Int> = axial(x, y)
	override val size: Axial<Int> = axial(width, height)
	
	override val x: Int
		get() = position.x
	
	override val y: Int
		get() = position.y
	
	override val width: Int
		get() = size.x
	
	override val height: Int
		get() = size.y
	
	override fun contains(p: Axial<Int>): Boolean {
		return contains(p.x, p.y)
	}
	
	override fun contains(x: Int, y: Int): Boolean {
		return this.x <= x && this.x + width > x && this.y <= y && this.y + height > y
	}
	
	override fun toString(): String {
		return position.toString() + ":" + size.toString()
	}
}