package ru.capjack.ktjs.common.rl

internal class RootFilePath : FilePath {
	override val value: String = ""
	override val valueAsDirectory: String = ""
	override val size: Int = 0
	override val parent: FilePath
		get() = throw IllegalStateException("No parent")
	
	override val name: FileName by lazy {
		FileNameImpl(value, 0)
	}
	
	override fun isFileExtension(value: String): Boolean {
		return false
	}
	
	override fun hasParent(): Boolean {
		return false
	}
	
	override fun resolve(path: String): FilePath {
		return FilePaths.get(path)
	}
	
	override fun resolve(path: FilePath): FilePath {
		return path
	}
	
	override fun resolveSibling(path: String): FilePath {
		throw UnsupportedOperationException("Is impossible resolve sibling on root path")
	}
	
	override fun resolveSibling(path: FilePath): FilePath {
		return resolveSibling(path.value)
	}
	
	override fun toString(): String {
		return value
	}
}