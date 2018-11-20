package ru.capjack.ktjs.common.js

import org.w3c.dom.Location

fun Location.fetchQueryParams(): LocationQueryParams {
	val params = jso<dynamic>()
	val pairs = (if (search[0] == '?') search.substring(1) else search).split('&')
	
	pairs.forEach { s ->
		val pair = s.split('=', limit = 2)
		params[decodeURIComponent(pair[0])] = decodeURIComponent(pair.getOrElse(1) { "" })
	}
	return LocationQueryParams(params)
	
}

class LocationQueryParams(private val data: dynamic) {
	operator fun get(name: String) = data[name].unsafeCast<String?>()
}

val Location.queryParams: LocationQueryParams
	get() {
		val l = this.asDynamic()
		if (l._queryParams == null) {
			l._queryParams = fetchQueryParams()
		}
		return l._queryParams.unsafeCast<LocationQueryParams>()
	}