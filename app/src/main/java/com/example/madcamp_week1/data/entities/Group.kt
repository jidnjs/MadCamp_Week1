package com.example.madcamp_week1.data.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "Group")
data class Group(
    @PrimaryKey(autoGenerate = true) val groupId: Long = 0,
    val groupName: String,
    val contactIdList: List<Long> = listOf()
)