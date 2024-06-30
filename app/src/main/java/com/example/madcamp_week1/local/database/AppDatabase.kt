package com.example.madcamp_week1.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.madcamp_week1.local.dao.ContactsDao
import com.example.madcamp_week1.local.dao.GroupsDao
import com.example.madcamp_week1.local.dao.TodoDao
import com.example.madcamp_week1.repository.model.Contact
import com.example.madcamp_week1.repository.model.Group
import com.example.madcamp_week1.repository.model.Todo

@Database(entities = [Contact::class, Group::class, Todo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao
    abstract fun groupsDao(): GroupsDao
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
