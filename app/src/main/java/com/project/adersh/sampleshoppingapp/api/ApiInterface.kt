package com.project.adersh.sampleshoppingapp.api

import com.project.adersh.sampleshoppingapp.model.Products
import com.project.adersh.sampleshoppingapp.model.ProductsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("products")
    suspend fun getProducts(): Response<Products>

    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") i: Int): Response<ProductsItem>
}