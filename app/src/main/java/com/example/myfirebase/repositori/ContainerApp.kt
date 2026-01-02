package com.example.myfirebase.repositori

import com.example.myfirebase.modeldata.Siswa
import kotlinx.coroutines.flow.Flow

interface RepositorySiswa {
    fun getAllSiswa(): Flow<List<Siswa>>
}