package com.example.android_course.datastores.domain

import java.math.BigDecimal

interface Datastore {
    fun getPrice(type: String): BigDecimal
}