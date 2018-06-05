package ru.capjack.ktjs.common.geom

import ru.capjack.ktjs.common.ChangeableImpl
import ru.capjack.ktjs.common.Destroyable

open class ChangeableAxialImpl<T>(x: T, y: T) : MutableAxialImpl<T>(x, y), ChangeableAxial<T>, Destroyable {
	private val changeable = ChangeableImpl()
	
	override fun onChange(handler: () -> Unit) = changeable.onChange(handler)
	
	override fun offChange(handler: () -> Unit) = changeable.offChange(handler)
	
	override fun destroy() = changeable.destroy()
	
	override var x: T
		get() = super.x
		set(value) {
			if (super.x != value) {
				super.x = value
				changeable.dispatchChange()
			}
		}
	
	override var y: T
		get() = super.y
		set(value) {
			if (super.y != value) {
				super.y = value
				changeable.dispatchChange()
			}
		}
	
	override fun set(x: T, y: T) {
		if (super.x != x || super.y != y) {
			super.x = x
			super.y = y
			changeable.dispatchChange()
		}
	}
}