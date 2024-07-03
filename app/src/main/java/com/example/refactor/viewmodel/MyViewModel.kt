package com.example.refactor.ui

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.refactor.data.AppDatabase
import com.example.refactor.data.entities.Contact
import com.example.refactor.data.entities.Group
import com.example.refactor.data.entities.Image
import com.example.refactor.data.entities.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {

    private val contactDao = AppDatabase.getDatabase(application).contactDao()
    private val groupDao = AppDatabase.getDatabase(application).groupDao()
    private val todoDao = AppDatabase.getDatabase(application).todoDao()
    private val imageDao = AppDatabase.getDatabase(application).imageDao()

    val allContacts: LiveData<List<Contact>> = contactDao.getAllContacts()
    val allGroups: LiveData<List<Group>> = groupDao.getAllGroups()
    val allTodos: LiveData<List<Todo>> = todoDao.getAllTodos()
    val allImages: LiveData<List<Image>> = imageDao.getAllImages()

    private val _addedGroupId = MutableLiveData<Long>()
    val addedGroupId: LiveData<Long> get() = _addedGroupId

    fun addGroup(group: Group) {
        viewModelScope.launch(Dispatchers.IO) {
            groupDao.insertGroup(group)
        }
        _addedGroupId.value = group.groupId
    }

    fun deleteGroup(groupId: Long) {
        viewModelScope.launch {
            val groupObj: Group = groupDao.getGroupByGroupIdSync(groupId)!!
            val contactList: List<Contact> = contactDao.getContactListByContactIdListSync(groupObj.contactIdList)
            contactList.map { updateContact(it.copy(groupIdList = it.groupIdList - groupId)) }
            val todoList: List<Todo> = todoDao.getAllTodosSync().filter{it.groupId == groupId}
            todoList.map {deleteTodo(it)}
            val imageList: List<Image> = imageDao.getAllImagesSync().filter{it.groupId == groupId}
            imageList.map {deleteImage(it)}
            groupDao.deleteGroup(groupObj)
        }
    }

    fun getGroupByGroupId(groupId: Long): LiveData<Group?> {
        return groupDao.getGroupByGroupId(groupId)
    }

    fun updateGroupsWithContactId(contactId: Long, prevGroupIdList: List<Long>, newGroupIdList: List<Long>) {
        Log.d("ContactDetailFragment", "currentList: $prevGroupIdList")
        Log.d("ContactDetailFragment", "newList: $newGroupIdList")
        viewModelScope.launch {
            val toRemoveGroupIdList: List<Long> = prevGroupIdList - newGroupIdList.toSet()
            val toAddGroupIdList: List<Long> = newGroupIdList - prevGroupIdList.toSet()
            groupDao.getGroupListByGroupIdListSync(toRemoveGroupIdList).map {
                groupDao.updateGroup(it.copy(contactIdList = (it.contactIdList.toSet() - contactId).toList()))
            }
            groupDao.getGroupListByGroupIdListSync(toAddGroupIdList).map {
                groupDao.updateGroup(it.copy(contactIdList = (it.contactIdList + contactId).toSet().toList()))
            }
        }
    }

    fun getGroupListByGroupIdList(groupIds: List<Long>): LiveData<List<Group>> {
        return groupDao.getGroupListByGroupIdList(groupIds)
    }

    // New method to get contacts by their IDs
    fun getContactListByContactIdList(contactIds: List<Long>): LiveData<List<Contact>> {
        return contactDao.getContactListByContactIdList(contactIds)
    }

    fun addContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDao.insertContact(contact)
        }
    }

    fun getContactByContactId(contactId: Long): LiveData<Contact?> {
        return contactDao.getContactByContactId(contactId)
    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDao.updateContact(contact)
        }
    }

    // Todo methods
    fun addTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.insertTodo(todo)
        }
    }

    fun getTodoByTodoId(todoId: Long): LiveData<Todo?> {
        return todoDao.getTodoByTodoId(todoId)
    }

    fun updateTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.updateTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            todoDao.deleteTodo(todo)
        }
    }

    fun deleteImage(image: Image) {
        viewModelScope.launch(Dispatchers.IO) {
            imageDao.deleteImage(image)
        }
    }

    fun getTodosByTodoIdList(todoIdList: List<Long>): LiveData<List<Todo>> {
        return todoDao.getTodosByTodoIdList(todoIdList)
    }

    fun addImage(image: Image){
        viewModelScope.launch(Dispatchers.IO) {
            imageDao.insertImage(image)
        }
    }

    fun getImageByImageId(imageId: Long): LiveData<Image?> {
        return imageDao.getImageByImageId(imageId)
    }
}
