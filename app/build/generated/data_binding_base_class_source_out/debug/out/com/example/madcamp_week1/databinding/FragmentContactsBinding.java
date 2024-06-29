// Generated by view binder compiler. Do not edit!
package com.example.madcamp_week1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.madcamp_week1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentContactsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnAddContact;

  @NonNull
  public final RecyclerView recyclerViewContacts;

  @NonNull
  public final TextView tvTotalContact;

  private FragmentContactsBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnAddContact,
      @NonNull RecyclerView recyclerViewContacts, @NonNull TextView tvTotalContact) {
    this.rootView = rootView;
    this.btnAddContact = btnAddContact;
    this.recyclerViewContacts = recyclerViewContacts;
    this.tvTotalContact = tvTotalContact;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentContactsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentContactsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_contacts, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentContactsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnAddContact;
      Button btnAddContact = ViewBindings.findChildViewById(rootView, id);
      if (btnAddContact == null) {
        break missingId;
      }

      id = R.id.recyclerViewContacts;
      RecyclerView recyclerViewContacts = ViewBindings.findChildViewById(rootView, id);
      if (recyclerViewContacts == null) {
        break missingId;
      }

      id = R.id.tvTotalContact;
      TextView tvTotalContact = ViewBindings.findChildViewById(rootView, id);
      if (tvTotalContact == null) {
        break missingId;
      }

      return new FragmentContactsBinding((ConstraintLayout) rootView, btnAddContact,
          recyclerViewContacts, tvTotalContact);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
