package ru.capjack.ktjs.common.rl

interface FilePath {
	val value: String
	val valueAsDirectory: String
	val size: Int
	val name: FileName
	val parent: FilePath
	
	fun isFileExtension(value: String): Boolean
	
	fun resolve(path: String): FilePath
	
	fun resolve(path: FilePath): FilePath
	
	fun resolveSibling(path: String): FilePath
	
	fun resolveSibling(path: FilePath): FilePath
	
	fun hasParent(): Boolean
}