package com.example.foodapplication.ui.favorite

import com.example.foodapplication.data.base.BasePresenter
import com.example.foodapplication.data.base.BaseView
import com.example.foodapplication.data.db.FavoriteEntity

interface FavoriteContracts {



    interface View{


        fun showGetAllFoods(data:MutableList<FavoriteEntity>)

fun emptyList()

    }


    interface Presenter:BasePresenter{

        fun getAllFoods()


    }
}