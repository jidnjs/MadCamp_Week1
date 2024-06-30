package com.example.madcamp_week1.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/example/madcamp_week1/local/dao/GroupsDao;", "", "deleteGroup", "", "group", "Lcom/example/madcamp_week1/repository/model/Group;", "(Lcom/example/madcamp_week1/repository/model/Group;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllGroups", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroupByGroupId", "groupId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroupListByGroupIdList", "groupIdList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertGroup", "updateGroup", "app_debug"})
@androidx.room.Dao
public abstract interface GroupsDao {
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertGroup(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Group group, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateGroup(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Group group, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteGroup(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Group group, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM `Group` WHERE groupId = :groupId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getGroupByGroupId(long groupId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.madcamp_week1.repository.model.Group> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM `Group`")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllGroups(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Group>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM `Group` WHERE groupId IN (:groupIdList)")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getGroupListByGroupIdList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> groupIdList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Group>> $completion);
}