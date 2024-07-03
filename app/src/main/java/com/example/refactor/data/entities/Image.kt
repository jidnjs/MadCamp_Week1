package com.example.refactor.data.entities

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Image")
data class Image(
    @PrimaryKey(autoGenerate = true) val imageId: Long = 0,  //random UUID
    val imageUri: Uri,  //path of image
    val favorite: Boolean = false,
    val date: Date,
    val loc: String = "",    //Seoul, HanRiver
    val groupId: Long
)