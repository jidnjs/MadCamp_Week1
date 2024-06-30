package com.example.madcamp_week1.repository

import com.example.madcamp_week1.repository.model.Contact
import com.example.madcamp_week1.repository.model.Group
import com.example.madcamp_week1.repository.model.Todo

interface Repository {
// GroupFun
    suspend fun insertGroup(group: Group)
    suspend fun updateGroup(group: Group)
    suspend fun deleteGroup(group: Group)

    suspend fun getGroup(groupId: Long): Group?
    suspend fun getAllGroups(): List<Group>

    suspend fun getGroupListByGroupIdList(groupIdList: List<Long>): List<Group>

// ContactFun
    suspend fun insertContact(contact: Contact)
    suspend fun updateContact(contact: Contact)
    suspend fun deleteContact(contact: Contact)

    suspend fun getContact(contactId: Long): Contact?
    suspend fun getAllContacts(): List<Contact>

    suspend fun getContactListByGroupId(groupId: Long): List<Contact>
    suspend fun getContactListByContactIdList(contactIdList: List<Long>): List<Contact>

// TodoFun
    suspend fun insertTodo(todo: Todo)
    suspend fun updateTodo(todo: Todo)
    suspend fun deleteTodo(todo: Todo)

    suspend fun getTodo(todoId: Long): Todo?
    suspend fun getAllTodo(): List<Todo>

    suspend fun getTodoListByGroupId(groupId: Long): List<Todo>
    suspend fun getTodoListByTodoIdList(todoIdList: List<Long>): List<Todo>
}
