package com.example.android_course.datastores.domain

import android.content.Context
import androidx.core.content.ContextCompat
import java.io.File
import java.math.BigDecimal

class FileDatastore(
    private val context: Context
): Datastore {
    override fun getPrice(type: String): BigDecimal = BigDecimal("300.00")


    private fun someIllustrations() {
        // корень файлохранилища приложения
        val filesDir = context.filesDir

        // открыть стрим в файл на чтение
        // use {  } -- закрывает стрим после использования. Будьте как use, закрывайте стрим.
        context.openFileOutput("slaves.txt", Context.MODE_PRIVATE).use {  }

        // открыть стрим на чтение
        context.openFileInput("slaves.txt").use {  }

        // список файлов в директории
        context.fileList()

        // создает временный кеш-файл, который точно будет удален вместе с приложением,
        // но может быть удален и раньше, если системе понадобится место
        File.createTempFile("temp_slaves.txt", null, context.cacheDir)

        // возвращает пути до папок приложения на различных внешних хранилищах
        ContextCompat.getExternalFilesDirs(context, null)
    }
}