package com.project.adersh.sampleshoppingapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.adersh.sampleshoppingapp.model.Products
import com.project.adersh.sampleshoppingapp.model.ProductsItem
import com.project.adersh.sampleshoppingapp.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    val products: LiveData<Products>
        get() = mainRepository.products

    val productDetails: LiveData<ProductsItem>
        get() = mainRepository.productDetails

    fun getProductsData() {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getProductsData()
        }
    }

    fun getProductsDetails(productId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            mainRepository.getProductDetails(productId)
        }
    }

}