package com.example.android_course.datastores.domain

import java.math.BigDecimal

class SimpleDatastore: Datastore {
    override var price: BigDecimal? = BigDecimal("300.00")
}