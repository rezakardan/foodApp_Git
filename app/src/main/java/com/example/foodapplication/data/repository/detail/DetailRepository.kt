package com.example.foodapplication.data.repository.detail

import com.example.foodapplication.data.db.FavoriteDao
import com.example.foodapplication.data.db.FavoriteEntity
import com.example.foodapplication.data.server.ApiService
import javax.inject.Inject

class DetailRepository@Inject constructor(private val api:ApiService,private val dao: FavoriteDao) {

    fun detailFoods(id:Int)=api.detailFoods(id)

fun insertFood(foodEntity: FavoriteEntity)=dao.insertFood(foodEntity)

    fun deleteFood(foodEntity: FavoriteEntity)=dao.deleteFood(foodEntity)


    fun existsFood(id: Int)=dao.existFood(id)





}