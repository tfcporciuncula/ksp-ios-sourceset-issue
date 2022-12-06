package com.fredporciuncula.ksp

import com.fredporciuncula.CommonComponent
import com.fredporciuncula.create // IDE doesn't understand this exists, even though it compiles

object CommonComponentProvider {
  val component = CommonComponent::class.create()
}
