package com.example.madcamp_week1.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.madcamp_week1.data.entities.Group

@Dao
interface GroupDao {
    @Insert suspend fun insertGroup(group: Group)
    @Update suspend fun updateGroup(group: Group)
    @Delete suspend fun deleteGroup(group: Group)

    @Query("SELECT * FROM `Group` WHERE groupId = :groupId")
    fun getGroupByGroupId(groupId: Long): LiveData<Group?>

    @Query("SELECT * FROM `Group` WHERE groupId = :groupId")
    suspend fun getGroupByGroupIdSync(groupId: Long): Group?

    @Query("SELECT * FROM `Group`")
    fun getAllGroups(): LiveData<List<Group>>

    @Query("SELECT * FROM `Group` WHERE groupId IN (:groupIdList)")
    fun getGroupListByGroupIdList(groupIdList: List<Long>): LiveData<List<Group>>

    @Query("SELECT * FROM `Group` WHERE groupId IN (:groupIdList)")
    suspend fun getGroupListByGroupIdListSync(groupIdList: List<Long>): List<Group>
}
