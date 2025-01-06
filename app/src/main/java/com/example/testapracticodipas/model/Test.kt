package com.example.testapracticodipas.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "test")
data class Test(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "slug")
    val desc: String,
    @ColumnInfo(name = "background_image")
    val image: String
)
