pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Laza"
include(":app")
include(":common")
include(":data")
include(":domain")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")