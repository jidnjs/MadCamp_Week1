package com.example.madcamp_week1.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/madcamp_week1/repository/DatabaseManager;", "", "()V", "appDatabase", "Lcom/example/madcamp_week1/local/database/AppDatabase;", "getContactsDao", "Lcom/example/madcamp_week1/local/dao/ContactsDao;", "getGroupsDao", "Lcom/example/madcamp_week1/local/dao/GroupsDao;", "getTodoDao", "Lcom/example/madcamp_week1/local/dao/TodoDao;", "init", "", "context", "Landroid/content/Context;", "app_debug"})
public final class DatabaseManager {
    @org.jetbrains.annotations.Nullable
    private static com.example.madcamp_week1.local.database.AppDatabase appDatabase;
    @org.jetbrains.annotations.NotNull
    public static final com.example.madcamp_week1.repository.DatabaseManager INSTANCE = null;
    
    private DatabaseManager() {
        super();
    }
    
    public final void init(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.madcamp_week1.local.dao.ContactsDao getContactsDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.madcamp_week1.local.dao.GroupsDao getGroupsDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.madcamp_week1.local.dao.TodoDao getTodoDao() {
        return null;
    }
}