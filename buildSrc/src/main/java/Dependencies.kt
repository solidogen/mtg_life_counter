import org.gradle.api.JavaVersion
import java.io.File
import java.util.*

object Versions {
    const val kotlin = "1.5.10"
    const val hilt = "2.36"
    const val junit = "4.13.2"
    const val timber = "4.7.1"
    const val coreKtx = "1.5.0-rc01"
    const val fragmentKtx = "1.3.2"
    const val appCompat = "1.3.0"
    const val material = "1.3.0"
    const val constraintLayout = "2.0.4"
    const val coroutines = "1.5.0"
    const val lifecycle = "2.4.0-alpha01"
    const val navigation = "2.3.5"
    const val desugarJdkLibs = "1.1.5"
    const val firebaseBom = "28.0.1"
    const val securityCrypto = "1.0.0-rc04"
    const val circleIndicator = "2.1.6"
    const val coil = "1.2.1"
    const val hyperion = "0.9.32"
    const val moshi = "1.12.0"
    const val blurry = "4.0.0"
    const val recycler = "1.2.0"
    const val flexbox = "3.0.0"
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.0"
    const val chucker = "3.4.0"
    const val documentFile = "1.0.1"
    const val croppingLibrary = "2.2.7"
    const val paging = "3.0.0"
    const val leakCanary = "2.7"
    const val swipeRefreshLayout = "1.1.0"
    const val room = "2.3.0"
}

object Module {
}

object AndroidSettings {
    const val applicationId = "com.spyrdonapps.mtglifecounter"
    const val minSdk = 23
    const val compileSdk = 30
    const val targetSdk = 30
    val versionCode: Int = File("version.properties")
        .let { file ->
            val properties = Properties().apply { file.takeIf { it.exists() }?.inputStream()?.use { load(it) } }
            properties.getProperty("versionCode")?.toInt()
        } ?: 1
    const val versionName = "0.0.1"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object JdkSettings {
    val sourceCompatibility = JavaVersion.VERSION_1_8
    val targetCompatibility = JavaVersion.VERSION_1_8
    const val jvmTarget = "1.8"
}

object Ui {
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val circleIndicator = "me.relex:circleindicator:${Versions.circleIndicator}"
    const val blurry = "jp.wasabeef:blurry:${Versions.blurry}"
    const val recycler = "androidx.recyclerview:recyclerview:${Versions.recycler}"
    const val flexbox = "com.google.android.flexbox:flexbox:${Versions.flexbox}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
}

object Common {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${Versions.desugarJdkLibs}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val documentFile = "androidx.documentfile:documentfile:${Versions.documentFile}"
    const val croppingLibrary = "com.github.yalantis:ucrop:${Versions.croppingLibrary}"
    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"
}

object Tests {
    const val junit = "junit:junit:${Versions.junit}"
}

object Hilt {
    const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val compilerKapt = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val androidTest = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val reactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:${Versions.coroutines}"
}

object Navigation {
    const val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
}

object Lifecycle {
    const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val process = "androidx.lifecycle:lifecycle-process:${Versions.lifecycle}"
}

object Firebase {
    const val bom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val crashlyticsKtx = "com.google.firebase:firebase-crashlytics-ktx"
    const val analyticsKtx = "com.google.firebase:firebase-analytics-ktx"
}

object Persistence {
    const val securityCrypto = "androidx.security:security-crypto:${Versions.securityCrypto}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
}

object Hyperion {
    const val core = "com.willowtreeapps.hyperion:hyperion-core:${Versions.hyperion}"
    const val recorder = "com.willowtreeapps.hyperion:hyperion-recorder:${Versions.hyperion}"
    const val attr = "com.willowtreeapps.hyperion:hyperion-attr:${Versions.hyperion}"
    const val measurement = "com.willowtreeapps.hyperion:hyperion-measurement:${Versions.hyperion}"
    const val timber = "com.willowtreeapps.hyperion:hyperion-timber:${Versions.hyperion}"
    const val coreNoOp = "com.willowtreeapps.hyperion:hyperion-core-no-op:${Versions.hyperion}"
}

object Serialization {
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
}

object Network {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"
}

object Performance {
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
}