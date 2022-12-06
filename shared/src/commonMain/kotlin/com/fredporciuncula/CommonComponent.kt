package com.fredporciuncula

import com.fredporciuncula.ksp.Greeting
import me.tatarka.inject.annotations.Component

@Component
abstract class CommonComponent {
  abstract val greeting: Greeting
}