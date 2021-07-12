plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}
//apply(from="https://raw.githubusercontent.com/JakeWharton/SdkSearch/master/gradle/projectDependencyGraph.gradle")

android {
    compileSdkVersion(AndroidSettings.compileSdk)
    defaultConfig {
        applicationId = AndroidSettings.applicationId
        minSdkVersion(AndroidSettings.minSdk)
        targetSdkVersion(AndroidSettings.targetSdk)
        versionCode = AndroidSettings.versionCode
        versionName = AndroidSettings.versionName
        testInstrumentationRunner = AndroidSettings.testInstrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    buildFeatures {
        viewBinding = true
    }
    lintOptions {
        isCheckReleaseBuilds = false
    }
}

hilt {
    enableExperimentalClasspathAggregation = true
}

dependencies {
    coreLibraryDesugaring(Common.desugarJdkLibs)

    implementation(Ui.material)
    implementation(Ui.constraintLayout)

    implementation(Common.coreKtx)
    implementation(Common.appCompat)
    implementation(Common.timber)

    implementation(Hilt.android)
    kapt(Hilt.compilerKapt)
    testImplementation(Hilt.androidTest)
    kaptTest(Hilt.compilerKapt)

    implementation(Navigation.fragmentKtx)
    implementation(Navigation.runtimeKtx)
    implementation(Navigation.uiKtx)

    implementation(Coroutines.core)
    implementation(Coroutines.android)
    implementation(Coroutines.reactive)

    implementation(Lifecycle.commonJava8)
    implementation(Lifecycle.liveDataKtx)
    implementation(Lifecycle.runtimeKtx)
    implementation(Lifecycle.viewModelKtx)
    implementation(Lifecycle.process)

    debugImplementation(Performance.leakCanary)
}