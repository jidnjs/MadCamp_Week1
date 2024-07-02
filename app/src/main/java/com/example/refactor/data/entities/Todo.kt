package com.example.refactor.data.entities

import androidx.room.*
import java.util.Date

@Entity(tableName = "Todo")
data class Todo(
    @PrimaryKey(autoGenerate = true) val todoId: Long = 0,
    val todoName: String,
    val todoContent: String = "",
    val todoDate: Date,
    val forallDay: Boolean = false,

    val groupId: Long // group id
)