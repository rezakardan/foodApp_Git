package com.example.foodapplication.data.repository.home

import com.example.foodapplication.data.server.ApiService
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api:ApiService) {

fun randomFood()=api.randomMeal()

    fun allMealsCategory()=api.allMealsCategory()


fun allMeals(letter:String)=api.allMeals(letter)

    fun searchMealsByName(name:String)=api.searchMealsByName(name)


fun filterByCategory(categoryName:String)=api.filterByCategoryName(categoryName)


}