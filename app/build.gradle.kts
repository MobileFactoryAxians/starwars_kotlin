plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.starwars"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.starwars"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    viewBinding {
        enable = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.android.car.ui:car-ui-lib:2.6.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.google.code.gson:gson:2.10.1")

    implementation ("com.jakewharton.threetenabp:threetenabp:1.4.6")
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    //FastAdapter
    val latestFastAdapterRelease = "5.7.0"
    implementation ("com.mikepenz:fastadapter:${latestFastAdapterRelease}")
    implementation ("com.mikepenz:fastadapter-extensions-expandable:${latestFastAdapterRelease}")
    implementation ("com.mikepenz:fastadapter-extensions-binding:${latestFastAdapterRelease}") // diff util helpers
    implementation ("com.mikepenz:fastadapter-extensions-diff:${latestFastAdapterRelease}") // diff util helpers
    implementation ("com.mikepenz:fastadapter-extensions-drag:${latestFastAdapterRelease}") // drag support
    implementation ("com.mikepenz:fastadapter-extensions-paged:${latestFastAdapterRelease}") // paging support
    implementation ("com.mikepenz:fastadapter-extensions-scroll:${latestFastAdapterRelease}") // scroll helpers
    implementation ("com.mikepenz:fastadapter-extensions-swipe:${latestFastAdapterRelease}") // swipe support
    implementation ("com.mikepenz:fastadapter-extensions-ui:${latestFastAdapterRelease}") // pre-defined ui components
    implementation ("com.mikepenz:fastadapter-extensions-utils:${latestFastAdapterRelease}") // needs the `expandable`, `drag` and `scroll` extension.

    kapt ("com.android.databinding:compiler:3.1.4")
}