package ru.capjack.ktjs.common.js

@JsName("PropertyDescriptor")
external interface JsPropertyDescriptor<T> {
	var configurable: Boolean
	var enumerable: Boolean
	var value: T
	var writable: Boolean
	var get: () -> T
	var set: (v: T) -> Unit
}