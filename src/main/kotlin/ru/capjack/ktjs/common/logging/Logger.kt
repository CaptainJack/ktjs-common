package ru.capjack.ktjs.common.logging

interface Logger {
	val name: String
	val level: Level
	
	val errorEnabled: Boolean
	val warnEnabled: Boolean
	val infoEnabled: Boolean
	val debugEnabled: Boolean
	val traceEnabled: Boolean
	
	fun isEnabled(level: Level): Boolean
	
	fun error(message: String, vararg args: dynamic)
	
	fun warn(message: String, vararg args: dynamic)
	
	fun info(message: String, vararg args: dynamic)
	
	fun debug(message: String, vararg args: dynamic)
	
	fun trace(message: String, vararg args: dynamic)
	
	fun log(level: Level, message: String, vararg args: dynamic)
}