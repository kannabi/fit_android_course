package com.example.android_course.datastores.domain

import java.math.BigDecimal

class SimpleDatastore: Datastore {
    override fun getPrice(type: String): BigDecimal = BigDecimal("300.00")
}