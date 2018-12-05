package ru.capjack.ktjs.common.rl

object Urls {
	val EMPTY: Url = UrlImpl("", "", FilePaths.ROOT)
	
	fun get(url: String): Url {
		if (url.isEmpty()) {
			return EMPTY
		}
		
		var path = url
		
		val scheme = when {
			path.startsWith("https://", true) -> "https"
			path.startsWith("http://", true)  -> "http"
			path.startsWith("file://", true)  -> "file"
			else                              -> ""
		}
		
		var host = ""
		
		if (scheme.isNotEmpty()) {
			path = path.substringAfter("//")
			host = path.substringBefore("/")
			path = path.substringAfter("/", "")
		}
		
		return UrlImpl(scheme, host, FilePaths.get(path))
	}
}