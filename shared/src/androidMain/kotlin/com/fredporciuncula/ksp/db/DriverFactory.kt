package com.fredporciuncula.ksp.db

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver

actual class DriverFactory {
  fun create(context: Context): AndroidSqliteDriver {
    return AndroidSqliteDriver(SomeDatabase.Schema, context, name = "db")
  }
}
