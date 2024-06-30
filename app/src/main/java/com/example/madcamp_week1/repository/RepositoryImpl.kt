package com.example.madcamp_week1.repository

import com.example.madcamp_week1.repository.DatabaseManager
import com.example.madcamp_week1.repository.model.Contact
import com.example.madcamp_week1.repository.model.Group
import com.example.madcamp_week1.repository.model.Todo

class RepositoryImpl : Repository {
    private val contactsDao = DatabaseManager.getContactsDao()
    private val groupsDao = DatabaseManager.getGroupsDao()
    private val todoDao = DatabaseManager.getTodoDao()

//    GroupFun
    override suspend fun insertGroup(group: Group) { groupsDao.insertGroup(group) }
    override suspend fun updateGroup(group: Group) { groupsDao.updateGroup(group) }
    override suspend fun deleteGroup(group: Group) { groupsDao.deleteGroup(group) }

    override suspend fun getGroup(groupId: Long): Group? {
        return groupsDao.getGroupByGroupId(groupId)
    }
    override suspend fun getAllGroups(): List<Group> {
        return groupsDao.getAllGroups()
    }

    override suspend fun getGroupListByGroupIdList(groupIdList: List<Long>): List<Group> {
        return groupsDao.getGroupListByGroupIdList(groupIdList)
    }

//    ContactFun
    override suspend fun insertContact(contact: Contact) { contactsDao.insertContact(contact) }
    override suspend fun updateContact(contact: Contact) { contactsDao.updateContact(contact) }
    override suspend fun deleteContact(contact: Contact) { contactsDao.deleteContact(contact) }

    override suspend fun getContact(contactId: Long): Contact? {
        return contactsDao.getContactByContactId(contactId)
    }
    override suspend fun getAllContacts(): List<Contact> {
        return contactsDao.getAllContacts()
    }

    override suspend fun getContactListByGroupId(groupId: Long): List<Contact> {
        return contactsDao.getContactListByGroupId(groupId)
    }
    override suspend fun getContactListByContactIdList(contactIdList: List<Long>): List<Contact> {
        return contactsDao.getContactListByContactIdList(contactIdList)
    }

//    TodoFun
    override suspend fun insertTodo(todo: Todo) { todoDao.insertTodo(todo) }
    override suspend fun updateTodo(todo: Todo) { todoDao.updateTodo(todo) }
    override suspend fun deleteTodo(todo: Todo) { todoDao.deleteTodo(todo) }

    override suspend fun getTodo(todoId: Long): Todo? {
        return todoDao.getTodoByTodoId(todoId)
    }
    override suspend fun getAllTodo(): List<Todo> {
        return todoDao.getAllTodo()
    }

    override suspend fun getTodoListByGroupId(groupId: Long): List<Todo> {
        return todoDao.getTodoListByGroupId(groupId)
    }
    override suspend fun getTodoListByTodoIdList(todoIdList: List<Long>): List<Todo> {
        return todoDao.getTodoListByTodoIdList(todoIdList)
    }
}
