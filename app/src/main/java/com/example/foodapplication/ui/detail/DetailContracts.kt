package com.example.foodapplication.ui.detail

import com.example.foodapplication.data.base.BasePresenter
import com.example.foodapplication.data.base.BaseView
import com.example.foodapplication.data.db.FavoriteEntity
import com.example.foodapplication.data.model.ResponseAllMealsByFirstLetter

interface DetailContracts  {

interface View:BaseView{


    fun showDetailFood(data:ResponseAllMealsByFirstLetter)



    fun showUpdateFood(isAdded:Boolean)


}

    interface Presenter:BasePresenter{


fun detailFoodApi(foodId:Int)



fun insertFood(foodEntity:FavoriteEntity)

fun deleteFood(foodEntity: FavoriteEntity)

fun existFood(id:Int)

    }




}