@file:Suppress("UnsafeCastFromDynamic", "NOTHING_TO_INLINE")

package ru.capjack.ktjs.common.js

inline fun <T> jsi(init: (T) -> Unit): T {
	val o: T = js("{}")
	init(o)
	return o
}

inline fun <T> jso(init: T.() -> Unit): T {
	val o: T = js("{}")
	o.init()
	return o
}

inline fun <T> jso(): T {
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

inline fun requireJs(path: String, noinline handler: () -> Unit) {
	js("require")(arrayOf(path), handler)
}

inline fun <T> requireJs(path: String, noinline handler: (T) -> Unit) {
	js("require")(arrayOf(path), handler)
}


fun convertErrorEventToString(@Suppress("UNUSED_PARAMETER") event: dynamic): String {
	return js(
		"""
			var eventClass = event.constructor && event.constructor.name;
			var error = event.error;
			var errorClass = error && (error.constructor ? error.constructor.name : error.name) || "?";
			var errorMessage = error ? (error.message || error.toString()) : event.message;
			errorMessage ? (errorClass + ": " + errorMessage + (eventClass !== "ErrorEvent" ? " (" + eventClass + "." + event.type + ")" : "")) : (eventClass + "." + event.type);
			"""
	)
}

external fun decodeURIComponent(value: String): String