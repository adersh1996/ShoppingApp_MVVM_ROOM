package com.project.adersh.sampleshoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.project.adersh.kotlinmvvm_demo.adapter.CustomAdapter
import com.project.adersh.sampleshoppingapp.api.ApiInterface
import com.project.adersh.sampleshoppingapp.api.ApiUtilities
import com.project.adersh.sampleshoppingapp.databinding.ActivityMainBinding
import com.project.adersh.sampleshoppingapp.databinding.ActivityProductDetailsBinding
import com.project.adersh.sampleshoppingapp.repository.MainRepository
import com.project.adersh.sampleshoppingapp.viewmodel.MainViewModel
import com.project.adersh.sampleshoppingapp.viewmodel.MyViewModelFactory

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = (application as MyApplication).mainRepository


        val productId:Int = intent.getIntExtra("product_id",0)

        mainViewModel = ViewModelProvider(
            this,
            MyViewModelFactory(repository)
        ).get(MainViewModel::class.java)

        mainViewModel.getProductsDetails(productId)

        mainViewModel.productDetails.observe(this) {

            binding.productPrice.setText(it.price.toString())
            binding.productName.setText(it.title)
            binding.productCategory.setText(it.category)
            binding.productDetails.setText(it.description)
            Glide.with(applicationContext).load(it.image).into(binding.productImage)



        }

    }
}