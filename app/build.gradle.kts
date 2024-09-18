import com.android.build.gradle.internal.utils.isKotlinKaptPluginApplied

plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
	id("kotlin-kapt")
}

android {
	namespace = "com.example.roomdatabasedemonew"
	compileSdk = 34
	
	defaultConfig {
		applicationId = "com.example.roomdatabasedemonew"
		minSdk = 24
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
	
	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
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
	
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
//	implementation(libs.mediation.test.suite)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	
	implementation (libs.androidx.room.runtime)
	kapt (libs.androidx.room.compiler) // For Kotlin use kapt instead of annotationProcessor
	implementation (libs.androidx.room.ktx) // Optional, for Kotlin extensions
	
	implementation (libs.androidx.lifecycle.viewmodel.ktx)
	implementation (libs.androidx.lifecycle.livedata.ktx)
	
	//implementation (libs.play.services.ads) // Use the latest version
	
}