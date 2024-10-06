plugins {
    id("com.android.library")
    alias(vcl.plugins.gene.android)
}

group = "io.github.5gene"
version = "0.1"

android {
    namespace = "osp.sparkj.dsl"
}

dependencies {
    implementation(wings.gene.cartoon)
    implementation(vcl.google.material)
}