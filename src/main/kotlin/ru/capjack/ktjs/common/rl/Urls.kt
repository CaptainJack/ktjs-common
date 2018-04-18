package ru.capjack.ktjs.common.rl

object Urls {
	val EMPTY: Url = UrlImpl("", "", FilePaths.ROOT)
	
	fun get(url: String): Url {
		if (url.isEmpty()) {
			return EMPTY
		}
		
		val r = Regex("(?:(http|https|file):)?(?://([a-zA-Z0-9.]+)/?)?(.+)")
		val result = (r.find(url) ?: throw IllegalArgumentException(url)).groupValues
		
		val scheme: String = result[1]
		val host: String = result[2]
		val path: String = result[3]
		
		return UrlImpl(scheme, host, FilePaths.get(path))
	}
}