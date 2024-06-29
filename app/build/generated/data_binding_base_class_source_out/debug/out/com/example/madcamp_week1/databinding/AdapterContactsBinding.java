// Generated by view binder compiler. Do not edit!
package com.example.madcamp_week1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.madcamp_week1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AdapterContactsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView tvContactName;

  @NonNull
  public final TextView tvContactPhoneNumber;

  private AdapterContactsBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView tvContactName, @NonNull TextView tvContactPhoneNumber) {
    this.rootView = rootView;
    this.tvContactName = tvContactName;
    this.tvContactPhoneNumber = tvContactPhoneNumber;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AdapterContactsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdapterContactsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.adapter_contacts, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdapterContactsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tvContactName;
      TextView tvContactName = ViewBindings.findChildViewById(rootView, id);
      if (tvContactName == null) {
        break missingId;
      }

      id = R.id.tvContactPhoneNumber;
      TextView tvContactPhoneNumber = ViewBindings.findChildViewById(rootView, id);
      if (tvContactPhoneNumber == null) {
        break missingId;
      }

      return new AdapterContactsBinding((ConstraintLayout) rootView, tvContactName,
          tvContactPhoneNumber);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
