package ru.capjack.ktjs.common.rl

interface FileName {
	val value: String
	val base: String
	val extension: String?
	val extensionAsSuffix: String
	
	fun hasExtension(): Boolean
}