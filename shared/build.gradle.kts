plugins {
    kotlin("multiplatform")
    id("com.android.library")
//    id("com.squareup.sqldelight").version("1.5.4")
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
//            linkerOpts.add("-lsqlite3") // iOS build only works with this
            export(project(":db"))
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":db"))
//                implementation("com.squareup.sqldelight:coroutines-extensions:1.5.4")
//                implementation("com.squareup.sqldelight:runtime:1.5.4")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
//            dependencies {
//                implementation("com.squareup.sqldelight:android-driver:1.5.4")
//            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
//            dependencies {
//                implementation("com.squareup.sqldelight:native-driver:1.5.4")
//            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

//sqldelight {
//  database("SomeDatabase") {
//    packageName = "com.fredporciuncula.ksp.db"
//  }
//}

android {
    namespace = "com.fredporciuncula.ksp"
    compileSdk = 32
    defaultConfig {
        minSdk = 26
        targetSdk = 32
    }
}