package com.example.refactor.data

import android.net.Uri
import androidx.room.TypeConverter
import java.net.URL
import java.util.Date

class Converters {
    @TypeConverter
    fun fromLongList(value: List<Long>): String {
        return value.joinToString(separator = ",")
    }

    @TypeConverter
    fun toLongList(value: String): List<Long> {
        if (value.isEmpty()) {
            return emptyList()
        }
        return value.split(",").mapNotNull {
            it.toLongOrNull()
        }
    }

    @TypeConverter
    fun toDate(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time.toLong()
    }

    @TypeConverter
    fun fromUri(uri: Uri): String {
        return uri.toString()
    }

    @TypeConverter
    fun toUri(uri: String): Uri {
        return Uri.parse(uri)
    }
}
