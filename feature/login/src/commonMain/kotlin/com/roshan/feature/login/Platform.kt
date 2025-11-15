package com.roshan.feature.login

interface Platform {
    val name: String
}

expect fun featurePlatform(): String