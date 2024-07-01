package com.example.refactor.data.repositories

import androidx.lifecycle.LiveData
import com.example.refactor.data.dao.ContactDao
import com.example.refactor.data.entities.Contact
import com.example.refactor.data.entities.Group

class ContactRepo(private val contactDao: ContactDao) {
    val allContactsLiveData: LiveData<List<Contact>> = contactDao.getAllContacts()

    suspend fun insert(contact: Contact) {
        contactDao.insertContact(contact)
    }

    suspend fun update(contact: Contact) {
        contactDao.updateContact(contact)
    }

    suspend fun delete(contact: Contact) {
        contactDao.deleteContact(contact)
    }

    fun getContactByContactId(contactId: Long): LiveData<Contact?> {
        return contactDao.getContactByContactId(contactId)
    }

    fun getAllContacts(): LiveData<List<Contact>> {
        return contactDao.getAllContacts()
    }

    fun getContactListByContactIdList(contactIdList: List<Long>): LiveData<List<Contact>> {
        return contactDao.getContactListByContactIdList(contactIdList)
    }
}
