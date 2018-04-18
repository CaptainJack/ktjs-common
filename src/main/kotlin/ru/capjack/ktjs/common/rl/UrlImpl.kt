package ru.capjack.ktjs.common.rl

internal class UrlImpl(
	override val scheme: String,
	override val host: String,
	override val path: FilePath
) : Url {
	override val value: String
		get() {
			val v = StringBuilder()
			if (scheme.isNotEmpty()) {
				v.append(scheme).append("://")
				if (scheme == "file") {
					v.append("/")
				}
			}
			if (host.isNotEmpty()) {
				if (scheme.isEmpty()) {
					v.append("//")
				}
				v.append(host)
			}
			val p = path.value
			if (p.isNotEmpty()) {
				if (host.isNotEmpty()) {
					v.append("/")
				}
				v.append(p)
			}
			return v.toString()
		}
	
	override fun resolvePath(path: String): Url {
		return UrlImpl(scheme, host, this.path.resolve(path))
	}
	
	override fun resolvePath(path: FilePath): Url {
		return UrlImpl(scheme, host, this.path.resolve(path))
	}
	
	override fun resolvePathSibling(path: String): Url {
		return UrlImpl(scheme, host, this.path.resolveSibling(path))
	}
	
	override fun resolvePathSibling(path: FilePath): Url {
		return UrlImpl(scheme, host, this.path.resolve(path))
	}
	
	override fun toString(): String {
		return value
	}
}