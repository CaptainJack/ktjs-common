rootProject.name = "ktjs-common"

pluginManagement {
	repositories {
		gradlePluginPortal()
		maven("http://artifactory.capjack.ru/public")
	}
	resolutionStrategy {
		eachPlugin {
			if (requested.id.id.startsWith("kotlin")) {
				useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
			}
			if (requested.id.id == "ru.capjack.degos-publish") {
				useModule("ru.capjack.degos:degos-publish:${requested.version}")
			}
		}
	}
}