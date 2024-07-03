package com.example.refactor.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.refactor.data.entities.Image

@Dao
interface ImageDao {
    @Insert suspend fun insertImage(image: Image)
    @Update suspend fun updateImage(image: Image)
    @Delete suspend fun deleteImage(image: Image)

    @Query("SELECT * FROM Image WHERE imageId = :imageId")
    fun getImageByImageId(imageId: Long): LiveData<Image?>

    @Query("SELECT * FROM Image")
    fun getAllImages(): LiveData<List<Image>>

    @Query("SELECT * FROM Image WHERE imageId IN (:imageIdList)")
    fun getImagesByImageIdList(imageIdList: List<Long>): LiveData<List<Image>>

    @Query("SELECT * FROM Image")
    suspend fun getAllImagesSync(): List<Image>
}