package com.example.foodapplication.data.server

import com.example.foodapplication.data.model.ResponseAllMealsByFirstLetter
import com.example.foodapplication.data.model.ResponseAllMealsCategory
import com.example.foodapplication.data.model.ResponseRandomFood
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("random.php")
fun randomMeal():Single<Response<ResponseRandomFood>>

@GET("categories.php")
fun allMealsCategory():Single<Response<ResponseAllMealsCategory>>


@GET("search.php")
fun allMeals(@Query("f")letter:String):Single<Response<ResponseAllMealsByFirstLetter>>

@GET("search.php")
fun searchMealsByName(@Query("s")name:String):Single<Response<ResponseAllMealsByFirstLetter>>


@GET("filter.php")
fun filterByCategoryName(@Query("c")categoryName:String):Single<Response<ResponseAllMealsByFirstLetter>>


@GET("lookup.php")
fun detailFoods(@Query("i")foodId:Int):Single<Response<ResponseAllMealsByFirstLetter>>
}