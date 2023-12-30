package com.project.adersh.sampleshoppingapp.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.project.adersh.sampleshoppingapp.model.Rating

class Converters {

    @TypeConverter
    fun fromRating(rating: Rating): String {
        return Gson().toJson(rating)
    }

    @TypeConverter
    fun toRating(ratingString: String): Rating {
        return Gson().fromJson(ratingString, Rating::class.java)
    }


}