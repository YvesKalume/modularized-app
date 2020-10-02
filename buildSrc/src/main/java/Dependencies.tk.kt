object App {
    const val compileSdkVersion = 29
    const val minSdkVersion = 21
    const val targetSdkVersion = 29
    const val versionName = "1.0"
}

object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:1.3.1"
    const val appCompat = "androidx.appcompat:appcompat:1.2.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.1"
    const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
    const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
    const val cardView = "androidx.cardview:cardview:1.0.0"
}

object Kotlin {
    private const val kotlin_version = "1.4.10"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
}

object LifeCycle {
    private const val lifecycleVersion = "2.2.0"
    const val extension = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
}

object Retrofit {
    private const val retrofitVersion = "2.9.0"
    const val coroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    const val gson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
}

object Koin {
    private const val koin_version = "2.1.6"
    const val android = "org.koin:koin-android:$koin_version"
    const val androidxScope = "org.koin:koin-androidx-scope:$koin_version"
    const val viewmodel = "org.koin:koin-androidx-viewmodel:$koin_version"
}

object Coroutines {
    private const val coroutinesVersion = "1.3.9"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
}

object TestDeps {
    const val jUnit = "junit:junit:4.13"
    const val junitExt = "androidx.test.ext:junit:1.1.2"
    const val expressoCore = "androidx.test.espresso:espresso-core:3.3.0"
}