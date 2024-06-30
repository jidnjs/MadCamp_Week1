package com.example.refactor.repository

data class Contact(
    val contactId: Long,

    val contactName: String,
    val contactPhoneNumber: Long = -1,

//    val contactEmail: String = "",
//    val contactMemo: String = "",

    val groupIdList: List<Long> = listOf<Long>()
)
