import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

group = "ru.capjack.ktjs"

plugins {
	id("kotlin2js") version "1.2.31"
	id("ru.capjack.degos-publish") version "1.3.1-dev.3+develop.0ee4745"
	id("nebula.release") version "6.0.0"
}

repositories {
	maven("http://artifactory.capjack.ru/public")
}

dependencies {
	compile(kotlin("stdlib-js"))
}

tasks.withType<Kotlin2JsCompile> {
	kotlinOptions {
		moduleKind = "amd"
	}
}
