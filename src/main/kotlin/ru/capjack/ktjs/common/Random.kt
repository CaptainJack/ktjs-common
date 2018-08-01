@file:Suppress("DEPRECATION")

package ru.capjack.ktjs.common

import kotlin.js.Math

object Random {
	fun makeBoolean(): Boolean {
		return makeInt(1024) >= 512
	}
	
	fun makeInt(): Int {
		return makeInt(Int.MAX_VALUE)
	}
	
	fun makeInt(bound: Int): Int {
		return when {
			bound == 1 -> 0
			bound > 0  -> (makePercent() * bound).toInt()
			bound == 0 -> throwZeroBound()
			else       -> throwNegativeBound(bound)
		}
	}
	
	fun makeInt(min: Int, max: Int): Int {
		return when {
			min < 0 || max < 0 -> throwNegativeLimits(min, max)
			min > max          -> throwInvalidLimits(min, max)
			else               -> makeInt(max - min + 1) + min
		}
	}
	
	fun makeLong(): Long {
		return makeLong(Long.MAX_VALUE)
	}
	
	fun makeLong(bound: Long): Long {
		return when {
			bound == 1L -> 0
			bound > 0   -> (makePercent() * bound).toLong()
			bound == 0L -> throwZeroBound()
			else        -> throwNegativeBound(bound)
		}
	}
	
	fun makeLong(min: Long, max: Long): Long {
		return when {
			min < 0 || max < 0 -> throwNegativeLimits(min, max)
			min > max          -> throwInvalidLimits(min, max)
			else               -> makeLong(max - min + 1) + min
		}
	}
	
	fun makeDouble(): Double {
		return makeDouble(Double.MAX_VALUE)
	}
	
	fun makeDouble(bound: Double): Double {
		return when {
			bound > 0    -> makePercent() * bound
			bound == 0.0 -> throwZeroBound()
			else         -> throwNegativeBound(bound)
		}
	}
	
	fun makeDouble(min: Double, max: Double): Double {
		return when {
			min < 0 || max < 0 -> throwNegativeLimits(min, max)
			min > max          -> throwInvalidLimits(min, max)
			else               -> makeDouble(max - min + 1) + min
		}
	}
	
	private fun makePercent(): Double {
		return Math.random()
	}
	
	private fun throwZeroBound(): Nothing {
		throw IllegalArgumentException("Zero bound is not allowed")
	}
	
	private fun throwNegativeBound(bound: Number): Nothing {
		throw IllegalArgumentException("Negative bound is not allowed ($bound)")
	}
	
	private fun throwNegativeLimits(min: Number, max: Number): Nothing {
		throw IllegalArgumentException("Negative limits is not allowed (min: $min, max: $max)")
	}
	
	private fun throwInvalidLimits(min: Number, max: Number): Nothing {
		throw IllegalArgumentException(message = "Invalid limits (min: $min, max: $max)")
	}
}