package com.example.foodapplication.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodapplication.utils.FOOD_TABLE_DATABASE

@Entity(tableName = FOOD_TABLE_DATABASE)
data class FavoriteEntity (

        @PrimaryKey(autoGenerate = true)
var id:Int=0,

        var title:String="",

        var image:String=""


        )