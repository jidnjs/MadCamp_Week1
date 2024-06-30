package com.example.madcamp_week1.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\u0012\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/example/madcamp_week1/local/dao/ContactsDao;", "", "deleteContact", "", "contact", "Lcom/example/madcamp_week1/repository/model/Contact;", "(Lcom/example/madcamp_week1/repository/model/Contact;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllContacts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactByContactId", "contactId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactListByContactIdList", "contactIdList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactListByGroupId", "groupId", "insertContact", "updateContact", "app_debug"})
@androidx.room.Dao
public abstract interface ContactsDao {
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertContact(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Contact contact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateContact(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Contact contact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteContact(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.model.Contact contact, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Contact WHERE contactId = :contactId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getContactByContactId(long contactId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.madcamp_week1.repository.model.Contact> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Contact")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllContacts(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Contact>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Contact WHERE group_id_list LIKE \'%\' || :groupId || \'%\'")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getContactListByGroupId(long groupId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Contact>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Contact WHERE contactId IN (:contactIdList)")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getContactListByContactIdList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> contactIdList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.madcamp_week1.repository.model.Contact>> $completion);
}