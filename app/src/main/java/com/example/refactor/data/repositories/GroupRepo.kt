package com.example.refactor.data.repositories

import androidx.lifecycle.LiveData
import com.example.refactor.data.dao.GroupDao
import com.example.refactor.data.entities.Group

class GroupRepo(private val groupDao: GroupDao) {
    val allGroupsLiveData: LiveData<List<Group>> = groupDao.getAllGroups()

    suspend fun insert(group: Group) {
        groupDao.insertGroup(group)
    }

    suspend fun update(group: Group) {
        groupDao.updateGroup(group)
    }

    suspend fun delete(group: Group) {
        groupDao.deleteGroup(group)
    }

    fun getGroupByGroupId(groupId: Long): LiveData<Group?> {
        return groupDao.getGroupByGroupId(groupId)
    }

    fun getAllGroups(): LiveData<List<Group>> {
        return groupDao.getAllGroups()
    }

    fun getGroupListByGroupIdList(groupIdList: List<Long>): LiveData<List<Group>> {
        return groupDao.getGroupListByGroupIdList(groupIdList)
    }
}
