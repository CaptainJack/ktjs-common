package ru.capjack.ktjs.common

interface Confines<out T> {
	val min: T
	val max: T
}