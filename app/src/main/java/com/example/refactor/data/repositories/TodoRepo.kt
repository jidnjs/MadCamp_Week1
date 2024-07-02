package com.example.refactor.data.repositories

import androidx.lifecycle.LiveData
import com.example.refactor.data.dao.TodoDao
import com.example.refactor.data.entities.Todo

class TodoRepo(private val todoDao: TodoDao) {
    val allTodosLiveData: LiveData<List<Todo>> = todoDao.getAllTodos()

    suspend fun insert(todo: Todo) {
        todoDao.insertTodo(todo)
    }

    suspend fun update(todo: Todo) {
        todoDao.updateTodo(todo)
    }

    suspend fun delete(todo: Todo) {
        todoDao.deleteTodo(todo)
    }

    fun getTodoByTodoId(todoId: Long): LiveData<Todo?> {
        return todoDao.getTodoByTodoId(todoId)
    }

    fun getAllTodos(): LiveData<List<Todo>> {
        return todoDao.getAllTodos()
    }

    fun getTodosByTodoIdList(todoIdList: List<Long>): LiveData<List<Todo>> {
        return todoDao.getTodosByTodoIdList(todoIdList)
    }
}
