plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
}

android {
    namespace = "ru.pyroman.masik.data.note.list"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(project(":common"))
    implementation(project(":data:note-data:note-common-data"))
    implementation(project(":domain:note-domain:note-list-domain"))
}