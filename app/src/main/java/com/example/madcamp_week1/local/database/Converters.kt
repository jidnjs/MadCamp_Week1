package com.example.madcamp_week1.local.database

import androidx.room.TypeConverter

import java.util.Date

class Converters {
    @TypeConverter
    fun fromList(value: List<Long>): String {
        return value.joinToString(",")
    }

    @TypeConverter
    fun toList(value: String): List<Long> {
        return value.split(",").map { it.toLong() }
    }

    @TypeConverter
    fun fromDate(value: Date): Long {
        return value.time
    }

    @TypeConverter
    fun toDate(value: Long): Date {
        return Date(value)
    }
}
