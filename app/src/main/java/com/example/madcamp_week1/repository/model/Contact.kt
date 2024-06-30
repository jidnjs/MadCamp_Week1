package com.example.madcamp_week1.repository.model

import androidx.room.*

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val contactId: Long,

    @ColumnInfo("contact_name")
    val contactName: String,

    @ColumnInfo("contact_phone_number")
    val contactPhoneNumber: Int,

//    val profilePic: Picture,
    @ColumnInfo("contact_email")
    val contactEmail: String = "",

    @ColumnInfo("contact_memo")
    val contactMemo: String = "",

    @ColumnInfo("group_id_list")
    val groupIdList: List<Long> = listOf<Long>()
)
