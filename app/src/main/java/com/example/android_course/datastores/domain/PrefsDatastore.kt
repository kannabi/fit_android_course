package com.example.android_course.datastores.domain

import android.content.Context
import java.math.BigDecimal

class PrefsDatastore(
    context: Context,
): Datastore {
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override var price: BigDecimal?
        get() {
            return prefs.getString(PRICE_PREF, null)?.let(::BigDecimal)
        }
        set(value) {
            prefs.edit().apply {
                putString(PRICE_PREF, value.toString())
                // сохранит асинхронно
                apply()

                // сохранит синхронно
                // commit
            }
        }

    companion object {
        private const val PREFS_NAME = "PREFS_NAME"

        private const val PRICE_PREF = "PRICE_PREF"
    }
}