package com.example.foodapplication.ui.home

import com.example.foodapplication.data.base.BasePresenter
import com.example.foodapplication.data.base.BaseView
import com.example.foodapplication.data.model.ResponseAllMealsByFirstLetter
import com.example.foodapplication.data.model.ResponseAllMealsCategory
import com.example.foodapplication.data.model.ResponseRandomFood

interface HomeContract {

    interface View:BaseView{

        fun showRandomMealApi(data: ResponseRandomFood)

fun showAllMealCategoryApi(data: ResponseAllMealsCategory)

fun showAllMealsApi(data: ResponseAllMealsByFirstLetter)

fun allMealsLoadingState(show:Boolean)

fun showEmptyList()
    }

    interface Presenter:BasePresenter{

fun callRandomMealApi()

fun callAllMealCategoryApi()

fun callAllMealsApi(letter:String)

fun searchMealsByName(name:String)

fun callFilterByCategoryApi(categoryName:String)
    }



}