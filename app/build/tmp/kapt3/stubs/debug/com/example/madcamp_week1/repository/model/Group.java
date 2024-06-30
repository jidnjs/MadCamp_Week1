package com.example.madcamp_week1.repository.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0003JM\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/example/madcamp_week1/repository/model/Group;", "", "groupId", "", "groupName", "", "contactIdList", "", "imageIdList", "todoIdList", "(JLjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getContactIdList", "()Ljava/util/List;", "getGroupId", "()J", "getGroupName", "()Ljava/lang/String;", "getImageIdList", "getTodoIdList", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity
public final class Group {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long groupId = 0L;
    @androidx.room.ColumnInfo(name = "group_name")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String groupName = null;
    @androidx.room.ColumnInfo(name = "contact_id_list")
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Long> contactIdList = null;
    @androidx.room.ColumnInfo(name = "image_id_list")
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Long> imageIdList = null;
    @androidx.room.ColumnInfo(name = "todo_id_list")
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Long> todoIdList = null;
    
    public Group(long groupId, @org.jetbrains.annotations.NotNull
    java.lang.String groupName, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> contactIdList, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> imageIdList, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> todoIdList) {
        super();
    }
    
    public final long getGroupId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGroupName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> getContactIdList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> getImageIdList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> getTodoIdList() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.madcamp_week1.repository.model.Group copy(long groupId, @org.jetbrains.annotations.NotNull
    java.lang.String groupName, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> contactIdList, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> imageIdList, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> todoIdList) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}