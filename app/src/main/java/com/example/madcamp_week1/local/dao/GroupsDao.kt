package com.example.madcamp_week1.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.madcamp_week1.repository.model.Group

@Dao
interface GroupsDao {
    @Insert suspend fun insertGroup(group: Group)
    @Update suspend fun updateGroup(group: Group)
    @Delete suspend fun deleteGroup(group: Group)

    @Query("SELECT * FROM `Group` WHERE groupId = :groupId")
    suspend fun getGroupByGroupId(groupId: Long): Group?

    @Query("SELECT * FROM `Group`")
    suspend fun getAllGroups(): List<Group>

    @Query("SELECT * FROM `Group` WHERE groupId IN (:groupIdList)")
    suspend fun getGroupListByGroupIdList(groupIdList: List<Long>): List<Group>
}
