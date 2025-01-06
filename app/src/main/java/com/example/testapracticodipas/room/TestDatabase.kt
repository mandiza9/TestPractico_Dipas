package com.example.testapracticodipas.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapracticodipas.model.Test

@Database(entities = [Test::class], version = 1, exportSchema = false)
abstract class TestDatabase: RoomDatabase() {
    abstract fun testDao(): TestDatabaseDao
}