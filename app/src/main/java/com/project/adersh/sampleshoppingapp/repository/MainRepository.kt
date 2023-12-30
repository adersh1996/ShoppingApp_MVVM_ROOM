package com.project.adersh.sampleshoppingapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.project.adersh.sampleshoppingapp.api.ApiInterface
import com.project.adersh.sampleshoppingapp.model.Products
import com.project.adersh.sampleshoppingapp.model.ProductsItem
import com.project.adersh.sampleshoppingapp.room.ProductDataBase
import com.project.adersh.sampleshoppingapp.utils.MyUtils

class MainRepository(
    private val apiInterface: ApiInterface,
    private val productDataBase: ProductDataBase,
    private val applicationContext: Context
) {
    private val productLiveData = MutableLiveData<Products>()
    private val productDetailsLiveData = MutableLiveData<ProductsItem>()
    val products: LiveData<Products>
        get() = productLiveData

    val productDetails: LiveData<ProductsItem>
        get() = productDetailsLiveData

    suspend fun getProductsData() {

        if (MyUtils.isInternetAvailable(applicationContext)){
            val result = apiInterface.getProducts()
            if (result.body() != null) {

                productDataBase.productDao().insertProducts(result.body()!!)

                productLiveData.postValue(result.body())
            }
        }else{
            val products = productDataBase.productDao().getProducts()

        }


    }

    suspend fun getProductDetails(productId: Int) {

        if (MyUtils.isInternetAvailable(applicationContext)){
            val result = apiInterface.getProductDetails(productId)
            if (result.body() != null) {
                productDetailsLiveData.postValue(result.body())
            }
        }else{
            val products = productDataBase.productDao().getProducts()

        }


    }

}