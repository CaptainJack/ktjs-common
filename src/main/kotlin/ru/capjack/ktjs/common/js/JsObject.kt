@file:Suppress("unused")

package ru.capjack.ktjs.common.js

@JsName("Object")
external object JsObject {
	fun <P, T : P> getPrototypeOf(o: T): P?
	fun <T> getOwnPropertyDescriptor(o: Any, p: String): JsPropertyDescriptor<T>
	fun getOwnPropertyNames(o: Any): Array<String>
	fun create(o: Nothing?, properties: dynamic = definedExternally): Any
	fun <T> create(o: T, properties: dynamic = definedExternally): T
	fun <T, P> defineProperty(o: T, p: String, attributes: JsPropertyDescriptor<P>): T
	fun <T> defineProperties(o: T, properties: dynamic): T
	fun <T> seal(o: T): T
	fun <R, T : R> freeze(o: T): R
	fun <T> preventExtensions(o: T): T
	fun isSealed(o: dynamic): Boolean
	fun isFrozen(o: dynamic): Boolean
	fun isExtensible(o: dynamic): Boolean
	fun keys(o: dynamic): Array<String>
}

