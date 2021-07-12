plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}
//apply(from="https://raw.githubusercontent.com/JakeWharton/SdkSearch/master/gradle/projectDependencyGraph.gradle")

android {
    compileSdk = AndroidSettings.compileSdk
    defaultConfig {
        applicationId = AndroidSettings.applicationId
        minSdk = AndroidSettings.minSdk
        targetSdk = AndroidSettings.targetSdk
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

hilt {
    enableExperimentalClasspathAggregation = true
}

dependencies {
    coreLibraryDesugaring(Common.desugarJdkLibs)

    implementation(Ui.material)
    implementation(Ui.constraintLayout)

    implementation(Compose.ui)
    implementation(Compose.uiGraphics)
    implementation(Compose.uiTooling)
    implementation(Compose.foundationLayout)
    implementation(Compose.material)
    implementation(Compose.navigation)
    implementation(Compose.accompanistCoil)
    implementation(Compose.accompanistPlaceholder)
    implementation(Compose.activityCompose)

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