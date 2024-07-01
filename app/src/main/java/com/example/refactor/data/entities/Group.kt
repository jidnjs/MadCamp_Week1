package com.example.refactor.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Group")
data class Group(
    @PrimaryKey(autoGenerate = true) val groupId: Long = 0,
    val groupName: String,

    val contactIdList: List<Long>
) {
    companion object {
        const val ALL_CONTACTS_ID = -2L
    }
}