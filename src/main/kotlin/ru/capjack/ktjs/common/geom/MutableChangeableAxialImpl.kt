package ru.capjack.ktjs.common.geom

import ru.capjack.ktjs.common.Changeable
import ru.capjack.ktjs.common.ChangeableObject
import ru.capjack.ktjs.common.Destroyable

open class MutableChangeableAxialImpl<T> private constructor(
	x: T,
	y: T,
	private val changeable: ChangeableObject<Axial<T>>

) : MutableChangeableAxial<T>,
	MutableAxialImpl<T>(x, y),
	Changeable<Axial<T>> by changeable,
	Destroyable by changeable {
	
	constructor(x: T, y: T) : this(x, y, ChangeableObject())
	
	override var x: T
		get() = super.x
		set(value) {
			if (super.x != value) {
				super.x = value
				changeable.introduceChange(this)
			}
		}
	
	override var y: T
		get() = super.y
		set(value) {
			if (super.y != value) {
				super.y = value
				changeable.introduceChange(this)
			}
		}
	
	override fun set(x: T, y: T) {
		if (super.x != x || super.y != y) {
			super.x = x
			super.y = y
			changeable.introduceChange(this)
		}
	}
}