package com.example.madcamp_week1.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.madcamp_week1.repository.model.Todo

@Dao
interface TodoDao {
    @Insert suspend fun insertTodo(todo: Todo)
    @Update suspend fun updateTodo(todo: Todo)
    @Delete suspend fun deleteTodo(todo: Todo)

    @Query("SELECT * FROM Todo WHERE todoId = :todoId")
    suspend fun getTodoByTodoId(todoId: Long): Todo

    @Query("SELECT * FROM Todo")
    suspend fun getAllTodo(): List<Todo>

    @Query("SELECT * FROM Todo WHERE group_id = :groupId")
    suspend fun getTodoListByGroupId(groupId: Long): List<Todo>

    @Query("SELECT * FROM Todo WHERE todoId IN (:todoIdList)")
    suspend fun getTodoListByTodoIdList(todoIdList: List<Long>): List<Todo>
}
