package com.example.foodapplication.data.base

interface BaseView {


    fun showProgress()
    fun hideProgress()


    fun isInternetOrNo():Boolean

    fun internetError(isInternet:Boolean)

    fun serverError(message:String)








}