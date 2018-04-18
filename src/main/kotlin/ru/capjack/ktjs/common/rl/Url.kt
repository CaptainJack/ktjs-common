package ru.capjack.ktjs.common.rl

interface Url {
	val value: String
	
	val scheme: String
	val host: String
	val path: FilePath
	
	fun resolvePath(path: String): Url
	
	fun resolvePath(path: FilePath): Url
	
	fun resolvePathSibling(path: String): Url
	
	fun resolvePathSibling(path: FilePath): Url
}