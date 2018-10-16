package ru.capjack.ktjs.common

open class ChangeableSelf<T : Changeable<T>> : AbstractChangeable<T>() {
	protected fun introduceChange() {
		super.introduceChange(this.unsafeCast<T>())
	}
}
