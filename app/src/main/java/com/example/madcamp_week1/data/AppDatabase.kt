package com.example.madcamp_week1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.madcamp_week1.data.dao.ContactDao
import com.example.madcamp_week1.data.dao.GroupDao
import com.example.madcamp_week1.data.dao.ImageDao
import com.example.madcamp_week1.data.dao.TodoDao
import com.example.madcamp_week1.data.entities.Contact
import com.example.madcamp_week1.data.entities.Group
import com.example.madcamp_week1.data.entities.Image
import com.example.madcamp_week1.data.entities.Todo

@Database(entities = [Group::class, Contact::class, Todo::class, Image::class], version = 8)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun groupDao(): GroupDao
    abstract fun contactDao(): ContactDao
    abstract fun todoDao(): TodoDao
    abstract fun imageDao(): ImageDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "app_database")
                .fallbackToDestructiveMigration()
                .build()
    }
}
