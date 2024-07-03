package com.example.madcamp_week1.model

import java.net.URL
import java.util.UUID

data class Image(
    val imageId: UUID,  //random UUID
    val imageURL: URL,  //path of image
    val favorite: Boolean,
    val imageTag: Int, //Group of the image
    val date: String, // data로 바꿈
    val dateTime: String,  //19:32:21
    val loc: String,    //Seoul, HanRiver
//    val metadata: Metadata

)

