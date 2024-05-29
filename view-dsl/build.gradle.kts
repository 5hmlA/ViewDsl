import wing.publish5hmlA

plugins {
    id("com.android.library")
    alias(wings.plugins.android)
}


group = "osp.sparkj.ui"
version = "2024.05.29"

publish5hmlA("android view dsl")

android {
    namespace = "osp.sparkj.wings"
}

dependencies {
    implementation(wings.sparkj.cartoon)
    implementation(libs.androidx.core.ktx)
    compileOnly("androidx.compose.ui:ui:+")
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.google.material)
}