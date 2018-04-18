package ru.capjack.ktjs.common.logging

interface Output {
	fun writeRecord(record: Record)
}