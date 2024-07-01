package com.example.refactor.data.entities

import androidx.room.TypeConverter

class GroupTypeConverters {

    @TypeConverter
    fun fromContactIdList(value: List<Long>): String {
        return value.joinToString(",")
    }

    @TypeConverter
    fun toContactIdList(value: String): List<Long> {
        return if (value.isEmpty()) {
            emptyList()
        } else {
            value.split(",").filter { it.isNotEmpty() }.map { it.toLong() }
        }
    }
}
