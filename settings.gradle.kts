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

rootProject.name = "FoodDelivery"
include(":app")
include(":login:data:remote")
include(":login:domain")
include(":login:presentation")
include(":login:ui")
include(":shared")
