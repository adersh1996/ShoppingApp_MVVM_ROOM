package com.project.adersh.sampleshoppingapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.adersh.sampleshoppingapp.api.ApiInterface
import com.project.adersh.sampleshoppingapp.model.Products
import com.project.adersh.sampleshoppingapp.model.ProductsItem

class MainRepository(private val apiInterface: ApiInterface) {
    private val productLiveData = MutableLiveData<Products>()
    private val productDetailsLiveData = MutableLiveData<ProductsItem>()
    val products: LiveData<Products>
        get() = productLiveData

    val productDetails: LiveData<ProductsItem>
        get() = productDetailsLiveData

    suspend fun getProductsData() {
        val result = apiInterface.getProducts()
        if (result.body() != null) {
            productLiveData.postValue(result.body())
        }
    }

    suspend fun getProductDetails(productId:Int) {
        val result = apiInterface.getProductDetails(productId)
        if (result.body() != null) {
            productDetailsLiveData.postValue(result.body())
        }
    }

}