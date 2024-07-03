package com.example.refactor.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.URL
import java.util.Date

@Entity(tableName = "Image")
data class Image(
    @PrimaryKey(autoGenerate = true) val imageId: Long = 0,  //random UUID
    val imageURL: URL,  //path of image
    val favorite: Boolean,
    val date: String,
    val loc: String,    //Seoul, HanRiver
    val groupId: Long
)