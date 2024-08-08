plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
}

val javaVersionNum: JavaVersion by rootProject.extra
val jvmToolchain: Int by rootProject.extra
val coreKtxVersion: String by rootProject.extra
val appcompatVersion: String by rootProject.extra
val materialVersion: String by rootProject.extra
val junitVersion: String by rootProject.extra
val junitTestVersion: String by rootProject.extra
val espressoVersion: String by rootProject.extra
val roomVersion: String by rootProject.extra
val gsonVersion: String by rootProject.extra
val desugarVersion: String by rootProject.extra

android {
    compileSdk = 34

    defaultConfig {
        multiDexEnabled = true
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        dataBinding = true
    }
    namespace = "com.app.dataBase"
    compileOptions {
        sourceCompatibility = javaVersionNum
        targetCompatibility = javaVersionNum
        isCoreLibraryDesugaringEnabled = true
    }
    kotlin {
        jvmToolchain(jvmToolchain)
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.appcompat:appcompat:$appcompatVersion")
    api("com.google.android.material:material:$materialVersion")
    testImplementation("junit:junit:$junitVersion")
    androidTestImplementation("androidx.test.ext:junit:$junitTestVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    testImplementation("androidx.room:room-testing:$roomVersion")
    implementation("com.google.code.gson:gson:$gsonVersion")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:$desugarVersion")
}