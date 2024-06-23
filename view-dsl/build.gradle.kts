plugins {
    id("com.android.library")
    alias(wings.plugins.android)
}


group = "osp.sparkj.ui"
version = "2024.06.06"

project.ext {
    set("GROUP_ID", "osp.sparkj.ui")
    set("ARTIFACT_ID", "view-dsl")
    set("VERSION", version.toString())
}
apply(from = "../publish-plugin.gradle")

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