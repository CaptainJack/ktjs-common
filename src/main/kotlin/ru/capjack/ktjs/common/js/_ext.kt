package ru.capjack.ktjs.common.js

import org.w3c.dom.Location

fun Location.fetchQueryParams(): dynamic {
	val params = jso<dynamic>()
	val pairs = (if (search[0] == '?') search.substring(1) else search).split('&')
	
	pairs.forEach { s ->
		val pair = s.split('=', limit = 2)
		params[decodeURIComponent(pair[0])] = decodeURIComponent(pair.getOrElse(1) { "" })
	}
	return params
	
}