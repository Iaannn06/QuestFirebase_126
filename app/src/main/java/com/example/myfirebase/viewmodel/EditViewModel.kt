package com.example.myfirebase.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.myfirebase.repositori.RepositorySiswa

class EditViewModel(savedStateHandle: SavedStateHandle, private val repositorySiswa: RepositorySiswa:
RepositorySiswa) : ViewModel() {
    var uiStateSiswa by mutableStateOf
}