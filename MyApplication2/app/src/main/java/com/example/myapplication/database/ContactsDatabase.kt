// ContactDatabase.kt
package com.example.myapplication.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.myapplication.model.Contact

class ContactsDatabase(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "ContactDatabase"
        const val TABLE_CONTACTS = "contacts"
        const val KEY_ID = "id"  // Example of internal visibility
        const val KEY_NAME = "name"
        const val KEY_PHONE_NUMBER = "phone_number"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createContactsTable = ("CREATE TABLE $TABLE_CONTACTS($KEY_ID INTEGER PRIMARY KEY, $KEY_NAME TEXT, $KEY_PHONE_NUMBER TEXT)")
        db?.execSQL(createContactsTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }

    fun addContact(name: String, phoneNumber: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(KEY_NAME, name)
            put(KEY_PHONE_NUMBER, phoneNumber)
        }
        db.insert(TABLE_CONTACTS, null, contentValues)
        db.close()
    }

    fun getAllContacts(): List<Contact> {
        val contactList = mutableListOf<Contact>()
        val selectQuery = "SELECT * FROM $TABLE_CONTACTS"
        val db = this.readableDatabase
        val cursor: Cursor? = db.rawQuery(selectQuery, null)
        cursor?.use {
            if (it.moveToFirst()) {
                do {
                    val contact = Contact(
                        id = it.getLong(it.getColumnIndex(KEY_ID)),
                        name = it.getString(it.getColumnIndex(KEY_NAME)),
                        phoneNumber = it.getString(it.getColumnIndex(KEY_PHONE_NUMBER))
                    )
                    contactList.add(contact)
                } while (it.moveToNext())
            }
        }
        cursor?.close()
        db.close()
        return contactList
    }
}
