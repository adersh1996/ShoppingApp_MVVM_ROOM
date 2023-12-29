package com.project.adersh.sampleshoppingapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.adersh.sampleshoppingapp.api.ApiInterface
import com.project.adersh.sampleshoppingapp.model.Products

class MainRepository(private val apiInterface: ApiInterface) {
    private val usersLiveData = MutableLiveData<Products>()
    val products: LiveData<Products>
        get() = usersLiveData

    suspend fun getProductsData() {
        val result = apiInterface.getProducts()
        if (result.body() != null) {
            usersLiveData.postValue(result.body())
        }
    }

}