package com.example.madcamp_week1.viewmodel

import androidx.lifecycle.ViewModel
import com.example.madcamp_week1.repository.Repository

class SharedViewModel(val repository: Repository) : ViewModel()