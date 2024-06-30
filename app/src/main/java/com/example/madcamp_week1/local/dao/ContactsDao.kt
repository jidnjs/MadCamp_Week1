// ContactDao.kt
package com.example.madcamp_week1.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.example.madcamp_week1.repository.model.Contact

@Dao
interface ContactsDao {
    @Insert suspend fun insertContact(contact: Contact)
    @Update suspend fun updateContact(contact: Contact)
    @Delete suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM Contact WHERE contactId = :contactId")
    suspend fun getContactByContactId(contactId: Long): Contact?

    @Query("SELECT * FROM Contact")
    suspend fun getAllContacts(): List<Contact>

    @Query("SELECT * FROM Contact WHERE group_id_list LIKE '%' || :groupId || '%'")
    suspend fun getContactListByGroupId(groupId: Long): List<Contact>

    @Query("SELECT * FROM Contact WHERE contactId IN (:contactIdList)")
    suspend fun getContactListByContactIdList(contactIdList: List<Long>): List<Contact>
}