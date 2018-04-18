@file:Suppress("UnsafeCastFromDynamic", "NOTHING_TO_INLINE")

package ru.capjack.ktjs.common.js

inline fun <T> jso(init: T.() -> Unit): T {
	val o: T = js("{}")
	o.init()
	return o
}

inline fun <T> jso(): T {
	return js("{}")
}

inline fun <T : Any> jst(init: T.() -> Unit): T {
	val o: T = js("{}")
	o.init()
	return o
}

inline fun <T : Any> jst(): T {
	return js("{}")
}

fun <V> toMap(src: dynamic): Map<String, V> {
	val map = HashMap<String, V>()
	JsObject.keys(src).forEach {
		map[it] = src[it]
	}
	return map
}

fun <E, V> toMap(src: dynamic, mapper: (E) -> V): Map<String, V> {
	val map = HashMap<String, V>()
	JsObject.keys(src).forEach {
		map[it] = mapper(src[it])
	}
	return map
}

fun requireJs(path: String, handler: () -> Unit) {
	js("require")(arrayOf(path), handler)
}