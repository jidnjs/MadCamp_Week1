package com.example.madcamp_week1.repository.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u00c6\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/example/madcamp_week1/repository/model/Contact;", "", "contactId", "", "contactName", "", "contactPhoneNumber", "", "contactEmail", "contactMemo", "groupIdList", "", "(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContactEmail", "()Ljava/lang/String;", "getContactId", "()J", "getContactMemo", "getContactName", "getContactPhoneNumber", "()I", "getGroupIdList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity
public final class Contact {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long contactId = 0L;
    @androidx.room.ColumnInfo(name = "contact_name")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String contactName = null;
    @androidx.room.ColumnInfo(name = "contact_phone_number")
    private final int contactPhoneNumber = 0;
    @androidx.room.ColumnInfo(name = "contact_email")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String contactEmail = null;
    @androidx.room.ColumnInfo(name = "contact_memo")
    @org.jetbrains.annotations.NotNull
    private final java.lang.String contactMemo = null;
    @androidx.room.ColumnInfo(name = "group_id_list")
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Long> groupIdList = null;
    
    public Contact(long contactId, @org.jetbrains.annotations.NotNull
    java.lang.String contactName, int contactPhoneNumber, @org.jetbrains.annotations.NotNull
    java.lang.String contactEmail, @org.jetbrains.annotations.NotNull
    java.lang.String contactMemo, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> groupIdList) {
        super();
    }
    
    public final long getContactId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContactName() {
        return null;
    }
    
    public final int getContactPhoneNumber() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContactEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContactMemo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> getGroupIdList() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.Long> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.madcamp_week1.repository.model.Contact copy(long contactId, @org.jetbrains.annotations.NotNull
    java.lang.String contactName, int contactPhoneNumber, @org.jetbrains.annotations.NotNull
    java.lang.String contactEmail, @org.jetbrains.annotations.NotNull
    java.lang.String contactMemo, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> groupIdList) {
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