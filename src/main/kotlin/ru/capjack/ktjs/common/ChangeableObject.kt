package ru.capjack.ktjs.common

open class ChangeableObject<T> : AbstractChangeable<T>() {
	public override fun introduceChange(value: T) {
		super.introduceChange(value)
	}
}