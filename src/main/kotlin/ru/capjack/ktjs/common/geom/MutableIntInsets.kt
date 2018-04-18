package ru.capjack.ktjs.common.geom

class MutableIntInsets(
	override var left: Int,
	override var right: Int,
	override var top: Int,
	override var bottom: Int
) : MutableInsets<Int> {
	
	override var horizontal: Int
		get() = left + right
		set(value) {
			left = value
			right = value
		}
	
	override var vertical: Int
		get() = top + bottom
		set(value) {
			top = value
			bottom = value
		}
	
	constructor(value: Int) : this(value, value)
	
	constructor(horizontal: Int, vertical: Int) : this(horizontal, horizontal, vertical, vertical)
	
	override fun set(left: Int, right: Int, top: Int, bottom: Int) {
		this.left = left
		this.right = right
		this.top = top
		this.bottom = bottom
	}
}