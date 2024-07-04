package com.example.madcamp_week1

import android.content.Context
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner

val View.lifecycleOwner: LifecycleOwner?
    get() = (context as? FragmentActivity)?.let { it as LifecycleOwner }
