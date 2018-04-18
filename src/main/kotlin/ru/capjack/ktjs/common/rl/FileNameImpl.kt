package ru.capjack.ktjs.common.rl

internal class FileNameImpl(private val path: String, private val offset: Int) : FileName {
	
	override val value: String
		get() = path.substring(offset)
	
	override val base: String
		get() = if (hasExtension()) path.substring(offset, extensionOffset - 1) else value
	
	override val extension: String?
		get() = if (hasExtension()) path.substring(extensionOffset) else null
	
	override val extensionAsSuffix: String
		get() = if (hasExtension()) ".$extension" else ""
	
	private val extensionOffset: Int
	
	init {
		val dotOffset = path.lastIndexOf('.')
		extensionOffset = when (dotOffset) {
			0, -1 -> 0
			else  -> dotOffset + 1
		}
	}
	
	override fun hasExtension(): Boolean {
		return extensionOffset != 0
	}
}