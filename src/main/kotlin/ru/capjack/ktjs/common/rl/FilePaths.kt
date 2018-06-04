package ru.capjack.ktjs.common.rl

object FilePaths {
	const val SEPARATOR: Char = '/'
	
	val ROOT: FilePath = RootFilePath()
	
	fun get(path: String): FilePath {
		return factory(ROOT, normalize(path))
	}
	
	internal fun normalize(path: String): String {
		return path.trim(SEPARATOR)
	}
	
	fun factory(ancestor: FilePath, path: String): FilePath {
		return if (path.isEmpty()) ancestor else BasicFilePath(ancestor, path)
	}
}