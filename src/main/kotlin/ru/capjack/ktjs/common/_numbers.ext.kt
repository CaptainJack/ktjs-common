package ru.capjack.ktjs.common

fun Double.toStringFormatted(thousandsSeparator: String = " ", fractionDigits: Int = 2): String {
	@Suppress("UnsafeCastFromDynamic")
	val str: String = asDynamic().toFixed(fractionDigits)
	
	return when (fractionDigits) {
		0    -> doToStringFormatted(str, 3, thousandsSeparator)
		else -> doToStringFormatted(str, 4 + fractionDigits, thousandsSeparator)
	}
}

fun Number.toStringFormatted(thousandsSeparator: String = " "): String {
	return doToStringFormatted(toString(), 3, thousandsSeparator)
}

private fun doToStringFormatted(str: String, start: Int, thousandsSeparator: String): String {
	var s = str
	if (thousandsSeparator.isNotEmpty()) {
		val f = if (str[0] == '-') 1 else 0
		var i = str.length - start
		while (i > f) {
			s = s.insert(i, thousandsSeparator)
			i -= 3
		}
	}
	return s
}