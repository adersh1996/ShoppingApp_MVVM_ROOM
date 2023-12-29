package com.project.adersh.sampleshoppingapp.api

import com.project.adersh.sampleshoppingapp.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    suspend fun getProducts():Response<Products>
}