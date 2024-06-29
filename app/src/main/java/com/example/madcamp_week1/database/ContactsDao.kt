// ContactDao.kt
package com.example.madcamp_week1.database

import com.example.madcamp_week1.model.Contact

interface ContactsDao {
    fun addContact(name: String, phoneNumber: String)
    fun getAllContacts(): List<Contact>
}