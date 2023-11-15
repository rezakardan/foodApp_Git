package com.example.foodapplication.ui.detail

import com.example.foodapplication.data.base.BasePresenterImpl
import com.example.foodapplication.data.db.FavoriteEntity
import com.example.foodapplication.data.repository.detail.DetailRepository
import com.example.foodapplication.utils.applyIoScheduler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val repository: DetailRepository,
    private val view: DetailContracts.View
) : DetailContracts.Presenter, BasePresenterImpl() {
    override fun detailFoodApi(foodId: Int) {

        if (view.isInternetOrNo()){
            view.showProgress()

            disposable=repository.detailFoods(foodId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response->
                    view.hideProgress()

                    when(response.code()){

                        in 200 .. 202->{

                            response.body()?.let {


                                if (it.meals!=null){
                                    if (it.meals.isNotEmpty()){

                                        view.showDetailFood(it)


                                    }

                                }






                            }




                        }



                    }






                },







                    {erroe->



                    view.hideProgress()
                    view.serverError(erroe.message.toString())



                })



        }else{

            view.internetError(false)


        }



    }

    override fun insertFood(foodEntity: FavoriteEntity) {
        disposable=repository.insertFood(foodEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{

                view.showUpdateFood(true)


            }
    }

    override fun deleteFood(foodEntity: FavoriteEntity) {
disposable=repository.deleteFood(foodEntity)
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe{

        view.showUpdateFood(false)

    }}

    override fun existFood(id: Int) {
disposable=repository.existsFood(id)
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe{

        view.showUpdateFood(it)

    }}


}

