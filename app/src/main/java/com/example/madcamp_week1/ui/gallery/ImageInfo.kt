// DummyImageInfo.kt
package com.example.madcamp_week1.ui.gallery

import com.example.madcamp_week1.model.Image
import java.net.URL
import java.util.UUID

object DummyImageInfo {
    fun getDummyImageInfo(): List<Image> {
        return listOf(
            Image(
                imageId = UUID.randomUUID(),
                imageURL = URL("file:///android_asset/image1.jpg"),
                favorite = false,
                imageTag = 1,
                date = "2023-07-01",
                dateTime = "19:32:21",
                loc = "Seoul, HanRiver",
            ),
            Image(
                imageId = UUID.randomUUID(),
                imageURL = URL("file:///android_asset/image2.jpg"),
                favorite = true,
                imageTag = 2,
                date = "2023-07-02",
                dateTime = "15:21:10",
                loc = "Seoul, Namsan",
            ),
            Image(
                imageId = UUID.randomUUID(),
                imageURL = URL("file:///android_asset/image3.jpg"),
                favorite = true,
                imageTag = 2,
                date = "2023-07-02",
                dateTime = "15:21:10",
                loc = "Seoul, Namsan",
            ),
            Image(
                imageId = UUID.randomUUID(),
                imageURL = URL("file:///android_asset/image4.jpg"),
                favorite = false,
                imageTag = 2,
                date = "2023-07-02",
                dateTime = "15:21:10",
                loc = "Seoul, Namsan",
            ),
            Image(
                imageId = UUID.randomUUID(),
                imageURL = URL("file:///android_asset/image5.jpg"),
                favorite = true,
                imageTag = 2,
                date = "2023-07-02",
                dateTime = "15:21:10",
                loc = "Seoul, Namsan",
            ),
        )
    }
}
