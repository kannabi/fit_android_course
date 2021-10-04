package com.example.android_course.service

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.example.android_course.R

class BackgroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)
//        registerReceiver(
//            MoneyBroadcastReceiver(),
//            IntentFilter().apply {
//                addAction("com.example.android_course.intent.HOW_ABOUT_MONEY")
//            }
//        )
//
//        startService(Intent(this, WhatsAboutMoneyService::class.java))

        val workManager = WorkManager.getInstance(this)

        val work: OneTimeWorkRequest = OneTimeWorkRequestBuilder<MoneyWork>().build()
        workManager.enqueue(work)

        workManager.getWorkInfoByIdLiveData(work.id).observe(this) {
            when (it.state) {
                WorkInfo.State.ENQUEUED -> TODO()
                WorkInfo.State.RUNNING -> TODO()
                WorkInfo.State.SUCCEEDED -> TODO()
                WorkInfo.State.FAILED -> TODO()
                WorkInfo.State.BLOCKED -> TODO()
                WorkInfo.State.CANCELLED -> TODO()
            }
        }
    }

    class MoneyWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
        override fun doWork(): Result {
            Thread.sleep(5000)
            return Result.success()
        }
    }
}