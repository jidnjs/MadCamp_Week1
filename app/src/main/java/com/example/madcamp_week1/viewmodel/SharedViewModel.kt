package com.example.madcamp_week1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.madcamp_week1.repository.Repository
import com.example.madcamp_week1.repository.model.Contact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SharedViewModel(val repository: Repository) : ViewModel() {

    suspend fun addContact(contact: Contact) {
        withContext(Dispatchers.IO) {
            repository.insertContact(contact)
        }
    }
}
