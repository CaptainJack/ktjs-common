package ru.capjack.ktjs.common.logging

import kotlin.browser.window

internal class LoggerImpl(
	override val name: String,
	override var level: Level,
	private val output: Output

) : Logger {
	
	override val errorEnabled: Boolean
		get() = isEnabled(Level.ERROR)
	
	override val warnEnabled: Boolean
		get() = isEnabled(Level.WARN)
	
	override val infoEnabled: Boolean
		get() = isEnabled(Level.INFO)
	
	override val debugEnabled: Boolean
		get() = isEnabled(Level.DEBUG)
	
	override val traceEnabled: Boolean
		get() = isEnabled(Level.TRACE)
	
	override fun isEnabled(level: Level): Boolean {
		return this.level.ordinal >= level.ordinal
	}
	
	override fun error(message: String, vararg args: Any?) {
		log(Level.ERROR, message, *args)
	}
	
	override fun warn(message: String, vararg args: Any?) {
		log(Level.WARN, message, *args)
	}
	
	override fun info(message: String, vararg args: Any?) {
		log(Level.INFO, message, *args)
	}
	
	override fun debug(message: String, vararg args: Any?) {
		log(Level.DEBUG, message, *args)
	}
	
	override fun trace(message: String, vararg args: Any?) {
		log(Level.TRACE, message, *args)
	}
	
	override fun log(level: Level, message: String, vararg args: Any?) {
		if (isEnabled(level)) {
			
			var formattedMessage = message
			var i = -1
			
			while (true) {
				++i
				val p = formattedMessage.indexOf("{}")
				if (p == -1 || i >= args.size) {
					break
				}
				formattedMessage = formattedMessage.replaceRange(p, p + 2, args[i].toString())
			}
			
			output.writeRecord(Record(window.performance.now(), name, level, formattedMessage, args.sliceArray(i until args.size)))
		}
	}
}