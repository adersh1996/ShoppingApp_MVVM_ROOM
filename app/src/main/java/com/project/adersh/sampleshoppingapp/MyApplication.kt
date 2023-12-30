package com.project.adersh.sampleshoppingapp

import android.app.Application
import com.project.adersh.sampleshoppingapp.api.ApiInterface
import com.project.adersh.sampleshoppingapp.api.ApiUtilities
import com.project.adersh.sampleshoppingapp.repository.MainRepository
import com.project.adersh.sampleshoppingapp.room.ProductDataBase

class MyApplication : Application() {
    lateinit var mainRepository: MainRepository
    override fun onCreate() {
        super.onCreate()

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val dataBase = ProductDataBase.getDatabase(applicationContext)
         mainRepository = MainRepository(apiInterface, dataBase,applicationContext)

    }
}