package com.fredporciuncula.ksp

import me.tatarka.inject.annotations.Inject

@Inject
class Greeting {
    private val platform: Platform = getPlatform()

    fun greeting(): String {
        return "Hello, ${platform.name}!"
    }
}