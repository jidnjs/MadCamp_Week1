package com.example.madcamp_week1.repository.model

import androidx.room.*
import java.util.Date

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val todoId: Long,

    @ColumnInfo("contact_id_list")
    val todoStartDate: Date,

//    val profilePic: Picture,
    @ColumnInfo("image_id_list")
    val todoEndDate: Date,

    @ColumnInfo("group_id")
    val groupId: Long // group id
)

