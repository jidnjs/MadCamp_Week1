package com.example.refactor.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.refactor.data.AppDatabase
import com.example.refactor.data.entities.Contact
import com.example.refactor.data.entities.Group
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private val contactDao = AppDatabase.getDatabase(application).contactDao()
    private val groupDao = AppDatabase.getDatabase(application).groupDao()

    val allContacts: LiveData<List<Contact>> = contactDao.getAllContacts()
    val allGroups: LiveData<List<Group>> = groupDao.getAllGroups()

    fun addContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDao.insertContact(contact)
        }
    }

    fun getContactByContactId(contactId: Long): LiveData<Contact?> {
        return contactDao.getContactByContactId(contactId)
    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDao.updateContact(contact)
        }
    }

    fun addGroup(group: Group) {
        viewModelScope.launch(Dispatchers.IO) {
            groupDao.insertGroup(group)
        }
    }

    // New method to get contacts by their IDs
    fun getContactListByContactIdList(contactIds: List<Long>): LiveData<List<Contact>> {
        return contactDao.getContactListByContactIdList(contactIds)
    }
}
