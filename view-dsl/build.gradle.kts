import com.android.build.api.dsl.LibraryExtension
import wing.androidExtension
import wing.publish5hmlA

plugins {
    id("com.android.library")
    alias(wings.plugins.android)
}


group = "osp.sparkj.ui"
version = "2024.06.06"

publish5hmlA("android view dsl", emptySourSets = true)

android {
    namespace = "osp.sparkj.dsl"
}

dependencies {
    implementation(wings.sparkj.cartoon)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.preference.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.google.material)
}