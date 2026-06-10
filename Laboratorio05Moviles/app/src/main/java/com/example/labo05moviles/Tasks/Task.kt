package com.example.labo05moviles.Tasks

import androidx.room.Database
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.RoomDatabase
import androidx.room.Insert
import androidx.room.Query
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.OnConflictStrategy
import java.util.Date

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val endDate: Date = Date(),
    val isCompleted: Boolean = false
)