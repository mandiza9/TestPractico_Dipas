package com.example.testapracticodipas.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.testapracticodipas.model.GamesList
import com.example.testapracticodipas.model.Test
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDatabaseDao {

    @Query("Select * from test")
    fun getGames(): List<Test>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<Test>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(test: Test)

    @Query("DELETE FROM test")
    fun deleteAll()

}