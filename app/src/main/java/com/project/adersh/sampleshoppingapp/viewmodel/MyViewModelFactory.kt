package com.project.adersh.sampleshoppingapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.adersh.sampleshoppingapp.repository.MainRepository

class MyViewModelFactory(private val mainRepository: MainRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.mainRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }


}