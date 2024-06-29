// ContactDao.kt
package com.example.myapplication.database

import com.example.myapplication.model.Contact

interface ContactsDao {
    fun addContact(name: String, phoneNumber: String)
    fun getAllContacts(): List<Contact>
}