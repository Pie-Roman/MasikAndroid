plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt.android)
}

android {
    namespace = "ru.pyroman.masik"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.pyroman.masik"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.uitoolingpreview)
    implementation(libs.androidx.compose.material3)

    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)

    implementation(project(":common"))

    implementation(project(":data:note-data:note-common-data"))
    implementation(project(":data:note-data:note-list-data"))

    implementation(project(":domain:note-domain:note-common-domain"))
    implementation(project(":domain:note-domain:note-list-domain"))

    implementation(project(":feature:tabs-feature"))
    implementation(project(":feature:note-feature:note-list-feature"))
}