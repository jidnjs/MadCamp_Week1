package com.example.madcamp_week1.ui.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/madcamp_week1/ui/adapter/ContactGroupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/madcamp_week1/ui/adapter/ContactGroupAdapter$ContactGroupViewHolder;", "groups", "", "Lcom/example/madcamp_week1/repository/model/Group;", "repository", "Lcom/example/madcamp_week1/repository/Repository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Ljava/util/List;Lcom/example/madcamp_week1/repository/Repository;Lkotlinx/coroutines/CoroutineScope;)V", "expandedPosition", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ContactGroupViewHolder", "app_debug"})
public final class ContactGroupAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.madcamp_week1.ui.adapter.ContactGroupAdapter.ContactGroupViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.madcamp_week1.repository.model.Group> groups = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.madcamp_week1.repository.Repository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private int expandedPosition = -1;
    
    public ContactGroupAdapter(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.madcamp_week1.repository.model.Group> groups, @org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.repository.Repository repository, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope scope) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.madcamp_week1.ui.adapter.ContactGroupAdapter.ContactGroupViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.madcamp_week1.ui.adapter.ContactGroupAdapter.ContactGroupViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/example/madcamp_week1/ui/adapter/ContactGroupAdapter$ContactGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/madcamp_week1/ui/adapter/ContactGroupAdapter;Landroid/view/View;)V", "contactRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getContactRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "groupName", "Landroid/widget/TextView;", "getGroupName", "()Landroid/widget/TextView;", "app_debug"})
    public final class ContactGroupViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView groupName = null;
        @org.jetbrains.annotations.NotNull
        private final androidx.recyclerview.widget.RecyclerView contactRecyclerView = null;
        
        public ContactGroupViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final android.widget.TextView getGroupName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final androidx.recyclerview.widget.RecyclerView getContactRecyclerView() {
            return null;
        }
    }
}