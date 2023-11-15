package com.example.foodapplication.ui.favorite

import com.example.foodapplication.data.base.BasePresenterImpl
import com.example.foodapplication.data.repository.favorite.FavoriteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class FavoritePresenter @Inject constructor(
    private val repository: FavoriteRepository,
    private val view: FavoriteContracts.View
):FavoriteContracts.Presenter,BasePresenterImpl() {
    override fun getAllFoods() {


        disposable=repository.getAllFoods()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{


if (it.isNotEmpty()){
    view.showGetAllFoods(it)



}else{

    view.emptyList()
}




            }
    }


}