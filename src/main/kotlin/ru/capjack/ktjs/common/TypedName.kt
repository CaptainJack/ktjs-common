package ru.capjack.ktjs.common

import kotlin.reflect.KClass

data class TypedName<T : Any>(
	val type: KClass<T>,
	val name: String
)

inline fun <reified T : Any> typedName(name: String) = TypedName(T::class, name)