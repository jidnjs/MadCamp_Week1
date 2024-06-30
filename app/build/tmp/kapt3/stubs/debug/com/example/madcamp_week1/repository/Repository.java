package com.example.madcamp_week1.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u001f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\u0006\u0010\u001c\u001a\u00020\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u001b\u0010 \u001a\u0004\u0018\u00010\r2\u0006\u0010!\u001a\u00020\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\u001c\u001a\u00020\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J%\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u00102\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160\u0010H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0019\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010&\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\'\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010(\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010)\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010*\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/example/madcamp_week1/repository/Repository;", "", "deleteContact", "", "contact", "Lcom/example/madcamp_week1/repository/model/Contact;", "(Lcom/example/madcamp_week1/repository/model/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGroup", "group", "Lcom/example/madcamp_week1/repository/model/Group;", "(Lcom/example/madcamp_week1/repository/model/Group;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTodo", "todo", "Lcom/example/madcamp_week1/repository/model/Todo;", "(Lcom/example/madcamp_week1/repository/model/Todo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllContacts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllGroups", "getAllTodo", "getContact", "contactId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactListByContactIdList", "contactIdList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactListByGroupId", "groupId", "getGroup", "getGroupListByGroupIdList", "groupIdList", "getTodo", "todoId", "getTodoListByGroupId", "getTodoListByTodoIdList", "todoIdList", "insertContact", "insertGroup", "insertTodo", "updateContact", "updateGroup", "updateTodo", "app_debug"})
public abstract interface Repository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertGroup(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Group group, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateGroup(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Group group, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteGroup(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Group group, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getGroup(long groupId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.madcamp_week1.repository.model.Group> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllGroups(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Group>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getGroupListByGroupIdList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> groupIdList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Group>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertContact(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Contact contact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateContact(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Contact contact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteContact(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Contact contact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getContact(long contactId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.madcamp_week1.repository.model.Contact> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllContacts(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Contact>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getContactListByGroupId(long groupId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Contact>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getContactListByContactIdList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> contactIdList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Contact>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTodo(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTodo(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTodo(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTodo(long todoId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.madcamp_week1.repository.model.Todo> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllTodo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Todo>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTodoListByGroupId(long groupId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Todo>> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTodoListByTodoIdList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> todoIdList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Todo>> $completion);
}