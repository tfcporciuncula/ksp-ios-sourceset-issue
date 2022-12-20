package com.fredporciuncula.ksp.db

import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DriverFactory {
  fun create(): NativeSqliteDriver {
    return NativeSqliteDriver(SomeDatabase.Schema, name = "db")
  }
}