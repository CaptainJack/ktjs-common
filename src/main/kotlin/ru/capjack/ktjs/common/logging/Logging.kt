package ru.capjack.ktjs.common.logging

import kotlin.reflect.KClass

object Logging {
	private var output = ProxyOutput(ConsoleOutput())
	private var defaultLevel: Level = Level.TRACE
	private var loggers: MutableMap<String, LoggerImpl> = mutableMapOf()
	private var levels: MutableMap<String, Level> = mutableMapOf()
	
	fun setOutput(value: Output) {
		output.target = value
	}
	
	fun setLevel(value: Level) {
		defaultLevel = value
	}
	
	fun setLevel(name: String, level: Level) {
		levels[name] = level
		val path = "$name."
		for (logger in loggers.values) {
			if (logger.name == name || level.name.startsWith(path)) {
				logger.level = level
			}
		}
	}
	
	fun get(name: String): Logger {
		return loggers.getOrPut(name) {
			LoggerImpl(name, defineLevel(name), output)
		}
	}
	
	fun get(type: KClass<*>): Logger {
		return get(type.simpleName!!)
	}
	
	fun get(path: String, type: KClass<*>): Logger {
		return get(path + "." + type.simpleName!!)
	}
	
	inline fun <reified T : Any> get(): Logger {
		return get(T::class)
	}
	
	inline fun <reified T : Any> get(path: String): Logger {
		return get(path, T::class)
	}
	
	private fun defineLevel(name: String): Level {
		var n = name
		
		while (true) {
			val level = levels[n]
			if (level != null) {
				return level
			}
			val i = n.lastIndexOf('.')
			if (i <= 0) {
				break
			}
			n = n.substring(0, i - 1)
		}
		
		return defaultLevel
	}
}