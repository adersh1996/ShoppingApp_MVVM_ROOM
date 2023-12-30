package com.project.adersh.sampleshoppingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.project.adersh.kotlinmvvm_demo.adapter.CustomAdapter
import com.project.adersh.sampleshoppingapp.viewmodel.MainViewModel
import com.project.adersh.sampleshoppingapp.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var productRecyclerView: RecyclerView
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productRecyclerView = findViewById(R.id.products_recycler_view)

        val repository = (application as MyApplication).mainRepository

        mainViewModel = ViewModelProvider(
            this,
            MyViewModelFactory(repository)
        ).get(MainViewModel::class.java)

        mainViewModel.getProductsData()

        mainViewModel.products.observe(this) {

            val customAdapter = CustomAdapter(applicationContext, it)
            productRecyclerView.adapter = customAdapter


        }


    }
}