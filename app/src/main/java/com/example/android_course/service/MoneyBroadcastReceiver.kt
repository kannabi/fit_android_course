package com.example.android_course.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MoneyBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(
            context,
            "Ну как там с деньгами?",
            Toast.LENGTH_LONG
        ).show()
    }
}