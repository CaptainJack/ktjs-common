package ru.capjack.ktjs.common

interface ChangeableValue<out V> : Changeable {
	val value: V
}