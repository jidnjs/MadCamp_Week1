package com.example.refactor.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.refactor.data.entities.Contact

@Dao
interface ContactDao {
    @Insert suspend fun insertContact(contact: Contact)
    @Update suspend fun updateContact(contact: Contact)
    @Delete suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM Contact WHERE contactId = :contactId")
    fun getContactByContactId(contactId: Long): LiveData<Contact?>

    @Query("SELECT * FROM Contact")
    fun getAllContacts(): LiveData<List<Contact>>

    @Query("SELECT * FROM Contact WHERE contactId IN (:contactIdList)")
    fun getContactListByContactIdList(contactIdList: List<Long>): LiveData<List<Contact>>

    @Query("SELECT * FROM Contact WHERE contactId IN (:contactIdList)")
    suspend fun getContactListByContactIdListSync(contactIdList: List<Long>): List<Contact>
}
