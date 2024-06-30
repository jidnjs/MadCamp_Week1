package com.example.refactor.repository

data class Group(
    val groupId: Long,
    val groupName: String,

    val contactIdList: List<Long> = listOf<Long>(),
    var contactIsExpanded: Boolean = false
)