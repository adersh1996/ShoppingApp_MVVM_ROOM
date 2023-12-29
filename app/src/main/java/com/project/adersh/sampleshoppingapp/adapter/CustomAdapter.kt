package com.project.adersh.kotlinmvvm_demo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.adersh.sampleshoppingapp.R
import com.project.adersh.sampleshoppingapp.model.Products


class CustomAdapter(
    private val context: Context,
    private val dataSet: Products
) : RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val productName: TextView
        val productPrice: TextView
        val productPRating: RatingBar
        val productImage: ImageView


        init {
            productName = itemView.findViewById(R.id.product_name)
            productPrice = itemView.findViewById(R.id.product_price)
            productPRating = itemView.findViewById(R.id.product_rating)
            productImage = itemView.findViewById(R.id.product_image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_layout, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.productName.text = dataSet.get(position).title
        holder.productPrice.text = dataSet.get(position).price.toString()
        holder.productPRating.rating = dataSet.get(position).rating.rate.toFloat()
        Glide.with(context).load(dataSet.get(position).image).into(holder.productImage)

    }


}