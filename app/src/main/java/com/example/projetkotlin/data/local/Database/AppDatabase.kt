package com.example.projetkotlin.data.local.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetkotlin.data.local.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}