package com.example.notesapplocal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NoteVMFactory(private val repository: NoteRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(repository) as T
    }
}