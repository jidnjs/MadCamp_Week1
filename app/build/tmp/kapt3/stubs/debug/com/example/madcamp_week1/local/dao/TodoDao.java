package com.example.madcamp_week1.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u000f\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/madcamp_week1/local/dao/TodoDao;", "", "deleteTodo", "", "todo", "Lcom/example/madcamp_week1/repository/model/Todo;", "(Lcom/example/madcamp_week1/repository/model/Todo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTodo", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodoByTodoId", "todoId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodoListByGroupId", "groupId", "getTodoListByTodoIdList", "todoIdList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTodo", "updateTodo", "app_debug"})
@androidx.room.Dao
public abstract interface TodoDao {
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTodo(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTodo(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTodo(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Todo WHERE todoId = :todoId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTodoByTodoId(long todoId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.madcamp_week1.repository.model.Todo> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Todo")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllTodo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Todo>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Todo WHERE group_id = :groupId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTodoListByGroupId(long groupId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Todo>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Todo WHERE todoId IN (:todoIdList)")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTodoListByTodoIdList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> todoIdList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Todo>> $completion);
}