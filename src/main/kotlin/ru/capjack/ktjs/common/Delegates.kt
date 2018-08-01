package ru.capjack.ktjs.common

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object Delegates {
	fun <T> observable(initialValue: T, onChange: (newValue: T) -> Unit): ReadWriteProperty<Any?, T> {
		return CorrectObservableProperty(initialValue, onChange)
	}
	
	fun <T> observable(initialValue: T, onChange: () -> Unit): ReadWriteProperty<Any?, T> {
		return CorrectObservableProperty(initialValue) { _ -> onChange() }
	}
	
	class CorrectObservableProperty<T>(
		private var value: T,
		private var handler: (value: T) -> Unit
	) : ReadWriteProperty<Any?, T> {
		
		override fun getValue(thisRef: Any?, property: KProperty<*>): T {
			return value
		}
		
		override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
			if (this.value != value) {
				this.value = value
				handler(value)
			}
		}
	}
}
