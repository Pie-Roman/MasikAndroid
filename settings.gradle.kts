pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "Masik"
include(":app")

include(":common")

include(":data:note-data")

include(":domain:note-domain")

include(":feature:main-feature")
include(":feature:note-feature")
include(":feature:order-taxi-feature")
include(":feature:photo-feature")
include(":feature:tabs-feature")
include(":feature:wishlist-feature")
