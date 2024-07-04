package com.example.madcamp_week1.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class Contact(
    @PrimaryKey(autoGenerate = true) val contactId: Long = 0,
    val contactName: String,
    val contactPhoneNumber: Long = -1,

    val contactEmail: String = "",
    val contactMemo: String = "",

    val groupIdList: List<Long> = listOf() // Foreign key reference to Group
)