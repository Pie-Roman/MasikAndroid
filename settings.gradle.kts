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

include(":data:common-data")

include(":data:note-data:note-common-data")
include(":data:note-data:note-list-data")

include(":domain:note-domain:note-common-domain")
include(":domain:note-domain:note-entry-domain")
include(":domain:note-domain:note-list-domain")

include(":feature:main-feature")

include(":feature:note-feature:note-entry-feature")
include(":feature:note-feature:note-list-feature")

include(":feature:order-taxi-feature")
include(":feature:photo-feature")
include(":feature:tabs-feature")
include(":feature:wishlist-feature")
