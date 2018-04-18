package ru.capjack.ktjs.common

class ProcedureGroupMap<K> {
	private val map: MutableMap<K, ProcedureGroup> = mutableMapOf()
	
	fun add(key: K, handler: Function<Unit>): Cancelable {
		return map.getOrPut(key, { ProcedureGroup() }).add(handler)
	}
	
	fun invoke(key: K, vararg args: Any?) {
		map[key]?.invoke(args)
	}
	
	fun clear() {
		for (group in map.values) {
			group.clear()
		}
		map.clear()
	}
}