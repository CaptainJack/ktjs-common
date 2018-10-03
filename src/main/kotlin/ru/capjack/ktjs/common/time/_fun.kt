package ru.capjack.ktjs.common.time

import kotlin.browser.window

internal fun defineCurrentTime(): Double {
	return window.performance.now()
}
