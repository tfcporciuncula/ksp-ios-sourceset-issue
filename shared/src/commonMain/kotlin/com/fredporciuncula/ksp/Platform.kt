package com.fredporciuncula.ksp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform