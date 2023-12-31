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
include(":register:domain")
include(":register:presentation")
include(":user:data:local")
include(":user:domain")
include(":onboarding:presentation")
include(":shared")
include(":register:data:remote")
