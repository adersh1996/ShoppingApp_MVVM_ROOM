package com.project.adersh.sampleshoppingapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.adersh.sampleshoppingapp.model.ProductsItem

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductsItem>)

    @Query("SELECT * FROM products")
    suspend fun getProducts(): List<ProductsItem>

}