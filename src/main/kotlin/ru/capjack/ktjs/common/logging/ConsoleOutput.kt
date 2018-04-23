package ru.capjack.ktjs.common.logging

class ConsoleOutput : Output {
	override fun writeRecord(record: Record) {
		when (record.level) {
			Level.ERROR -> console.asDynamic().error
			Level.WARN  -> console.asDynamic().warn
			Level.INFO  -> console.asDynamic().info
			Level.DEBUG -> console.asDynamic().log
			Level.TRACE -> console.asDynamic().log
		}.apply(
			null,
			arrayOf(
				"[${record.level.name.padEnd(5)}] [${record.logger}] ${record.message}",
				*record.messageArguments
			)		)
	}
}
