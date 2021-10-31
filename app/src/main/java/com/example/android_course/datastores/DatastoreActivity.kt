package com.example.android_course.datastores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.android_course.R
import com.example.android_course.datastores.domain.Datastore
import com.example.android_course.datastores.shitty_di.DatastoreInjectable
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class DatastoreActivity : AppCompatActivity(), DatastoreInjectable {

    private lateinit var datastore: Datastore
    private lateinit var priceInput: EditText
    private val currency: Currency = Currency.getInstance("USD")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datastore)
    }

    override fun onStart() {
        super.onStart()
        initPriceFromCache()
        priceInput = findViewById(R.id.price_input)
        findViewById<Button>(R.id.price_enter).setOnClickListener {
            datastore.price =
                priceInput.text.toString()
                    .takeIf(String::isNotBlank)
                    .let(::BigDecimal)
        }
    }

    private fun initPriceFromCache() {
        val formatter = DecimalFormat(
            "#,###.00",
            DecimalFormatSymbols.getInstance()
                .apply {
                    decimalSeparator = '.'
                    groupingSeparator = ' '
                }
        )
        findViewById<TextView>(R.id.price).text =
            datastore.price
                ?.let { "${formatter.format(it)} $currency" }
    }

    override fun injectDatastore(datastore: Datastore) {
        this.datastore = datastore
    }
}