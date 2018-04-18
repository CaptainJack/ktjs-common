package ru.capjack.ktjs.common.logging

class Record(
	val time: Double,
	val logger: String,
	val level: Level,
	val message: String,
	val messageArguments: Array<dynamic>
)
