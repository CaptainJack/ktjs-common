package ru.capjack.ktjs.common.events

interface EventInlet<in E> {
	fun introduceEvent(event: E)
}