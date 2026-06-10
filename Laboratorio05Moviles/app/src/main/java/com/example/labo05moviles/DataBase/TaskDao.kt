package com.example.labo05moviles.DataBase

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
import com.example.labo05moviles.Tasks.Task
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface TaskDao {

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)
}

class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}

@Database(
    entities = [Task::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}

