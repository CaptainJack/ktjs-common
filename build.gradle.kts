import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import ru.capjack.degos.publish.DegosPublishExtension

group = "ru.capjack.ktjs"

plugins {
	id("kotlin2js") version "1.2.51"
	id("ru.capjack.degos.publish") version "1.7.0"
	id("nebula.release") version "6.3.5"
}

repositories {
	maven("http://artifactory.capjack.ru/public")
}

dependencies {
	implementation(kotlin("stdlib-js"))
}

tasks.withType<Kotlin2JsCompile> {
	kotlinOptions {
		moduleKind = "umd"
		sourceMap = true
		sourceMapEmbedSources = "always"
	}
}
