package com.hajar.managementusers

import android.app.Application
import androidx.room.Room
import com.hajar.managementusers.data.AppDatabase

class UserApplication : Application() {
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "user-database").build()
    }
}
