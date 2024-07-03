package com.example.refactor.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.refactor.data.entities.Todo

@Dao
interface TodoDao {
    @Insert suspend fun insertTodo(todo: Todo)
    @Update suspend fun updateTodo(todo: Todo)
    @Delete suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM Todo WHERE todoId = :todoId")
    fun getTodoByTodoId(todoId: Long): LiveData<Todo?>

    @Query("SELECT * FROM Todo")
    fun getAllTodos(): LiveData<List<Todo>>

    @Query("SELECT * FROM Todo WHERE todoId IN (:todoIdList)")
    fun getTodosByTodoIdList(todoIdList: List<Long>): LiveData<List<Todo>>

    @Query("SELECT * FROM Todo")
    suspend fun getAllTodosSync(): List<Todo>
}
