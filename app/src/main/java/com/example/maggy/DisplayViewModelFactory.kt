package com.example.maggy

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DisplayViewModelFactory(
    private val repo: Repo
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DisplayViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DisplayViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
