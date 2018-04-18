package ru.capjack.ktjs.common.geom

import ru.capjack.ktjs.common.ChangeableImpl

open class ChangeableAxialValues<T>(
	horizontal: T,
	vertical: T = horizontal
) : ChangeableImpl(), MutableAxialValues<T> {
	
	private var _horizontal: T = horizontal
	private var _vertical: T = vertical
	
	override var horizontal: T
		get() = _horizontal
		set(value) {
			if (_horizontal != value) {
				_horizontal = value
				dispatchChange()
			}
		}
	
	override var vertical: T
		get() = _vertical
		set(value) {
			if (_vertical != value) {
				_vertical = value
				dispatchChange()
			}
		}
	
	override fun set(horizontal: T, vertical: T) {
		if (_horizontal != horizontal || _vertical != vertical) {
			_horizontal = horizontal
			_vertical = vertical
			dispatchChange()
		}
	}
	
	override fun toString(): String {
		return "${horizontal}x$vertical"
	}
}