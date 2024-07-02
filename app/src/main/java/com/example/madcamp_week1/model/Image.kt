package com.example.madcamp_week1.model

data class Image(
    val imageId: Long,
    val favorite: Boolean,
    val imageTag: List<Long>, //Group ID 배열
    val date: String, // data로 바꿈
    val dateTime: Int,
    val loc: String,
    val metadata: Metadata

)

