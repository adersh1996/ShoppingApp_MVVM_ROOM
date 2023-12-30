package com.project.adersh.sampleshoppingapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.adersh.sampleshoppingapp.model.ProductsItem

@Database(entities = [ProductsItem::class], version = 1)
@TypeConverters(Converters::class)
abstract class ProductDataBase:RoomDatabase() {

    abstract fun productDao():RoomDao

    companion object{
        private var INSTANCE: ProductDataBase? = null
        fun getDatabase (context: Context): ProductDataBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder (
                    context,
                    ProductDataBase::class.java,
                 "productDB"
                ).build()
            }
            return INSTANCE!!
        }
    }
}