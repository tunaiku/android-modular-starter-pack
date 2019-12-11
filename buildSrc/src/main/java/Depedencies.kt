/**
 *
 * Created by Wahyu Permadi on 2019-12-11.
 * Android Engineer
 *
 **/

object ApplicationId {
    const val appId = "com.godohdev.modular_architecture"
}

object Release {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val minSdk = 19
    const val compiledSdk = 29
    const val targetSdk = 29

//    Android Library
    const val coreKtxVersion = "1.1.0"
    const val appCompatVersion = "1.1.0"
    const val kotlinVersion = "1.3.61"

//    Testing Library
    const val mockkVersion = "1.9.3"
    const val jUnitVersion = "4.12"
    const val jUnitTestVersion = "1.1.1"
    const val espressoCoreVersion = "3.2.0"

//    Network
    const val gson = "2.8.5"
    const val okHttp = "3.12.1"
    const val retrofit = "2.6.1"

//    UI
    const val anko = "0.10.8"
    const val material = "1.0.0"
    const val glide = "4.10.0"

//    Threading
    const val rxJava = "2.2.12"

}

object Libraries {

//    Android Library
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"

//    Testing Library
    const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    const val jUnit = "junit:junit:${Versions.jUnitVersion}"
    const val jUnitTest = "androidx.test.ext:junit:${Versions.jUnitTestVersion}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"

//    Network
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitRxAdapter ="com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val rx = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
}