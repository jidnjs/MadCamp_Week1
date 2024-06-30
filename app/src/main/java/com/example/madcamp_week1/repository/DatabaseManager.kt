package com.example.madcamp_week1.repository

import android.content.Context
import com.example.madcamp_week1.local.dao.ContactsDao
import com.example.madcamp_week1.local.dao.GroupsDao
import com.example.madcamp_week1.local.dao.TodoDao
import com.example.madcamp_week1.local.database.AppDatabase

object DatabaseManager {
    private var appDatabase: AppDatabase? = null
    //

    fun init(context: Context) {
        appDatabase = AppDatabase.getDatabase(context)
    }

    fun getContactsDao(): ContactsDao {
        return appDatabase!!.contactsDao()
    }

    fun getGroupsDao(): GroupsDao {
        return appDatabase!!.groupsDao()
    }

    fun getTodoDao(): TodoDao {
        return appDatabase!!.todoDao()
    }
}