package com.example.madcamp_week1.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u001b\u0010\u001b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\u0006\u0010#\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u001b\u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ%\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u00172\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u001b\u0010\'\u001a\u0004\u0018\u00010\u00142\u0006\u0010(\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140\u00172\u0006\u0010#\u001a\u00020\u001dH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001eJ%\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010,\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010-\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u0010.\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010/\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u00100\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u0019\u00101\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/example/madcamp_week1/repository/RepositoryImpl;", "Lcom/example/madcamp_week1/repository/Repository;", "()V", "contactsDao", "Lcom/example/madcamp_week1/local/dao/ContactsDao;", "groupsDao", "Lcom/example/madcamp_week1/local/dao/GroupsDao;", "todoDao", "Lcom/example/madcamp_week1/local/dao/TodoDao;", "deleteContact", "", "contact", "Lcom/example/madcamp_week1/repository/model/Contact;", "(Lcom/example/madcamp_week1/repository/model/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGroup", "group", "Lcom/example/madcamp_week1/repository/model/Group;", "(Lcom/example/madcamp_week1/repository/model/Group;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTodo", "todo", "Lcom/example/madcamp_week1/repository/model/Todo;", "(Lcom/example/madcamp_week1/repository/model/Todo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllContacts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllGroups", "getAllTodo", "getContact", "contactId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactListByContactIdList", "contactIdList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactListByGroupId", "groupId", "getGroup", "getGroupListByGroupIdList", "groupIdList", "getTodo", "todoId", "getTodoListByGroupId", "getTodoListByTodoIdList", "todoIdList", "insertContact", "insertGroup", "insertTodo", "updateContact", "updateGroup", "updateTodo", "app_debug"})
public final class RepositoryImpl implements com.example.madcamp_week1.repository.Repository {
    @org.jetbrains.annotations.NotNull
    private final com.example.madcamp_week1.local.dao.ContactsDao contactsDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.madcamp_week1.local.dao.GroupsDao groupsDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.madcamp_week1.local.dao.TodoDao todoDao = null;
    
    public RepositoryImpl() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertGroup(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Group group, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateGroup(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Group group, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteGroup(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Group group, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getGroup(long groupId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.madcamp_week1.repository.model.Group> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getAllGroups(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Group>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getGroupListByGroupIdList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> groupIdList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Group>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertContact(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Contact contact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateContact(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Contact contact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteContact(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Contact contact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getContact(long contactId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.madcamp_week1.repository.model.Contact> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getAllContacts(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Contact>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getContactListByGroupId(long groupId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Contact>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getContactListByContactIdList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> contactIdList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Contact>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object insertTodo(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateTodo(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object deleteTodo(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTodo(long todoId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.madcamp_week1.repository.model.Todo> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getAllTodo(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Todo>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTodoListByGroupId(long groupId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Todo>> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getTodoListByTodoIdList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> todoIdList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Todo>> $completion) {
        return null;
    }
}