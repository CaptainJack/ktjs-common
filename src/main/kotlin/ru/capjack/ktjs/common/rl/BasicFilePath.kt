package ru.capjack.ktjs.common.rl

internal class BasicFilePath(private var ancestor: FilePath, private var path: String) : FilePath {
	override val value: String
		get() = ancestor.valueAsDirectory + path
	
	override val valueAsDirectory: String
		get() = value + FilePaths.SEPARATOR
	
	override val name: FileName by lazy {
		FileNameImpl(path, pathOffsets.last())
	}
	
	override val size: Int
		get() = ancestor.size + pathOffsets.size
	
	override val parent: FilePath
		get() =
			if (pathOffsets.size == 1) ancestor
			else {
				FilePaths.factory(ancestor, path.substring(0, pathOffsets.last() - 1))
			}
	
	private val pathOffsets: Array<Int> by lazy {
		val list = mutableListOf(0)
		var i = 0
		while (true) {
			i = path.indexOf(FilePaths.SEPARATOR, i) + 1
			if (i == 0) {
				break
			}
			list.add(i)
		}
		list.toTypedArray()
	}
	
	override fun isFileExtension(value: String): Boolean {
		return path.substringAfterLast('.', "") == value
	}
	
	override fun hasParent(): Boolean {
		return true
	}
	
	override fun resolve(path: String): FilePath {
		return FilePaths.factory(this, FilePaths.normalize(path))
	}
	
	override fun resolve(path: FilePath): FilePath {
		return FilePaths.factory(this, path.value)
	}
	
	override fun resolveSibling(path: String): FilePath {
		return parent.resolve(path)
	}
	
	override fun resolveSibling(path: FilePath): FilePath {
		return parent.resolve(path)
	}
	
	override fun toString(): String {
		return value
	}
}

