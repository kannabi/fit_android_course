package com.example.android_course.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper

class WhatsAboutMoneyService: Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Handler(Looper.getMainLooper()).postDelayed({
            Intent().apply {
                action = "com.example.android_course.intent.HOW_ABOUT_MONEY"
            }.let(::sendBroadcast)
            stopSelf()
        }, 3000L)

        return super.onStartCommand(intent, flags, startId)
    }
}