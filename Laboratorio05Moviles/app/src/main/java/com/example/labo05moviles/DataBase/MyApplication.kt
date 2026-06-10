package com.example.labo05moviles.DataBase

import android.app.Application
import androidx.room.Room


class MyApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "task_database"
        ).build()
    }
}