package com.example.madcamp_week1.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.Date

@Entity(tableName = "Todo")
data class Todo(
    @PrimaryKey(autoGenerate = true) val todoId: Long = 0,
    val todoName: String,
    val todoContent: String = "",
    val todoDate: Date,

    val groupId: Long // group id
): Serializable