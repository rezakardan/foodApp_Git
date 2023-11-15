package com.example.foodapplication.data.repository.favorite

import com.example.foodapplication.data.db.FavoriteDao
import javax.inject.Inject

class FavoriteRepository@Inject constructor(private val dao:FavoriteDao) {

    fun getAllFoods()=dao.getAllFoods()


}