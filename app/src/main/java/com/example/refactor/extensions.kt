package com.example.refactor

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner

val View.lifecycleOwner: LifecycleOwner?
    get() = (context as? FragmentActivity)?.let { it as LifecycleOwner }
