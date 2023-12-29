package com.project.adersh.sampleshoppingapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.adersh.sampleshoppingapp.model.Products
import com.project.adersh.sampleshoppingapp.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) :ViewModel(){

    init {
        viewModelScope.launch (Dispatchers.IO){
            mainRepository.getProductsData()
        }
    }
    val products:LiveData<Products>
        get() = mainRepository.products

}