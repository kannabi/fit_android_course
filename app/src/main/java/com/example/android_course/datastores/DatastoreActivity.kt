package com.example.android_course.datastores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.android_course.R
import com.example.android_course.datastores.domain.Datastore
import com.example.android_course.datastores.shitty_di.DatastoreInjectable
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class DatastoreActivity : AppCompatActivity(), DatastoreInjectable {

    private lateinit var datastore: Datastore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datastore)
    }

    override fun onResume() {
        super.onResume()

        val formatter = DecimalFormat(
            "#,###.00",
            DecimalFormatSymbols.getInstance()
                .apply {
                    decimalSeparator = '.'
                    groupingSeparator = ' '
                }
        )
        findViewById<TextView>(R.id.price).text =
            datastore.getPrice("whatever")
                .let { "${formatter.format(it)} ${Currency.getInstance("USD")}" }
    }

    override fun injectDatastore(datastore: Datastore) {
        this.datastore = datastore
    }
}