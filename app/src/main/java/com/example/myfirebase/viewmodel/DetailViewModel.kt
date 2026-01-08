package com.example.myfirebase.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirebase.modeldata.Siswa
import com.example.myfirebase.repositori.RepositorySiswa
import com.example.myfirebase.view.route.DestinasiDetail
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import java.io.IOException

sealed interface StatusUIDetail {
    data class Success(val siswa: Siswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}

class DetailViewModel(savedStateHandle: SavedStateHandle, private val repositorySiswa: RepositorySiswa:
RepositorySiswa ) : ViewModel(){

    private val idSiswa: Long =
        savedStateHandle.get<String>(DestinasiDetail.itemIdArg)?.toLong()
            ?: error("idSiswa tidak ditemukan di SavedStateHandle")
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
    private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa(){
        viewModelScope.launch {
            statusUIDetail = statusUIDetail.Loading
            statusUIDetail = try {
                statusUIDetail.Success(satusiswa = repositorySiswa.getSatuSiswa(idSiswa) )
            }
            catch (e: IOException) {
                StatusUIDetail.Error
            }
            catch(e: Exception) {
                statusUIDetail.Error
            }
        }
    }

    suspend fun hapusSatuSiswa(){
        try {
            repositorySiswa.hapusSatuSiswa(idSiswa)
            printIn("Sukses Hapus Data: $idSiswa")
        } catch (e: Exception) {
            printIn("Gagal Hapus Data: $e.message")
        }
    }
}
