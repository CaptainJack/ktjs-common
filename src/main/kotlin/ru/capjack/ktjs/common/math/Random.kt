@file:Suppress("DEPRECATION")

package ru.capjack.ktjs.common.math

import kotlin.js.Math.random

object Random {
	fun make(bound: Int): Int {
		return (random() * bound).toInt()
	}
	
	fun make(from: Int, to: Int): Int {
		return (random() * (to - from + 1)).toInt() + from
	}
	
	fun <T> take(array: Array<T>): T {
		return array[make(array.size)]
	}
	
	fun <T> take(list: List<T>): T {
		return list[make(list.size)]
	}
	
	fun take(list: IntArray): Int {
		return list[make(list.size)]
	}
	
	fun take(list: DoubleArray): Double {
		return list[make(list.size)]
	}
	
	fun bool(): Boolean {
		return make(1024) >= 512
	}
}