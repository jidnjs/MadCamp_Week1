// Generated by view binder compiler. Do not edit!
package com.example.madcamp_week1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.madcamp_week1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddContactBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonSaveContact;

  @NonNull
  public final EditText etContactName;

  @NonNull
  public final EditText etContactPhone;

  private FragmentAddContactBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonSaveContact, @NonNull EditText etContactName,
      @NonNull EditText etContactPhone) {
    this.rootView = rootView;
    this.buttonSaveContact = buttonSaveContact;
    this.etContactName = etContactName;
    this.etContactPhone = etContactPhone;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddContactBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddContactBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_add_contact, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddContactBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonSaveContact;
      Button buttonSaveContact = ViewBindings.findChildViewById(rootView, id);
      if (buttonSaveContact == null) {
        break missingId;
      }

      id = R.id.etContactName;
      EditText etContactName = ViewBindings.findChildViewById(rootView, id);
      if (etContactName == null) {
        break missingId;
      }

      id = R.id.etContactPhone;
      EditText etContactPhone = ViewBindings.findChildViewById(rootView, id);
      if (etContactPhone == null) {
        break missingId;
      }

      return new FragmentAddContactBinding((ConstraintLayout) rootView, buttonSaveContact,
          etContactName, etContactPhone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
