package ru.capjack.ktjs.common

interface ChangeableValue<out V> : Changeable<V> {
	val value: V
}