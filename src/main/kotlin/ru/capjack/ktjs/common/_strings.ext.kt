package ru.capjack.ktjs.common


fun CharSequence.insert(position: Int, insertion: String, deleteLength: Int = 0): String {
	return substring(0, position) + insertion + substring(position + deleteLength)
}

fun String.format(vararg args: Any): String {
	return format(args.toList())
}

fun String.format(args: List<Any>): String {
	var string = this
	for (arg in args) {
		string = string.replaceFirst("{}", arg.toString())
	}
	return string
}
