package com.example.madcamp_week1.repository.model

import androidx.room.*

@Entity
data class Group(
    @PrimaryKey(autoGenerate = true)
    val groupId: Long,

    @ColumnInfo("group_name")
    val groupName: String,

    @ColumnInfo("contact_id_list")
    val contactIdList: List<Long> = listOf<Long>(),

//    val profilePic: Picture,
    @ColumnInfo("image_id_list")
    val imageIdList: List<Long> = listOf<Long>(),

    @ColumnInfo("todo_id_list")
    val todoIdList: List<Long> = listOf<Long>()
)

