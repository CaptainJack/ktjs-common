package ru.capjack.ktjs.common.events

interface EventDispatcher<in E : Any> : EventInlet<E>, EventDealer<E>