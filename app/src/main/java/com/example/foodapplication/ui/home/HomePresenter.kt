package com.example.foodapplication.ui.home

import com.example.foodapplication.data.base.BasePresenterImpl
import com.example.foodapplication.data.repository.home.HomeRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomePresenter @Inject constructor(
    val repository: HomeRepository, val view: HomeContract.View

) : HomeContract.Presenter, BasePresenterImpl() {
    override fun callRandomMealApi() {

        disposable = repository.randomFood()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->


                if (view.isInternetOrNo()) {
                    when (response.code()) {


                        in 200..202 -> {

                            response.body()?.let {

                                view.showRandomMealApi(it)


                            }

                        }
                    }


                } else {


                    view.internetError(false)
                }


            }, { error ->

                view.serverError(error.message.toString())


            })


    }

    override fun callAllMealCategoryApi() {

        if (view.isInternetOrNo()) {
            view.showProgress()
            disposable = repository.allMealsCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    view.hideProgress()
                    when (response.code()) {

                        in 200..202 -> {

                            response.body()?.let {
                                if (it.categories.isNotEmpty()) {
                                    view.showAllMealCategoryApi(it)
                                }

                            }

                        }

                    }


                }, { error ->


                    view.hideProgress()
                    view.serverError(error.message.toString())


                })


        } else {
            view.internetError(false)
        }


    }

    override fun callAllMealsApi(letter: String) {

        if (view.isInternetOrNo()){

            view.allMealsLoadingState(true)

            disposable=repository.allMeals( letter)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response->

                    view.allMealsLoadingState(false)

                    when(response.code()){


                        in 200 .. 202->{

                            response.body().let {

                               if (it?.meals!!.isNotEmpty()){

                                   view.showAllMealsApi(it)

                               }


                            }




                            }

                    }




                },



                    {error->

                        view.allMealsLoadingState(false)
                        view.serverError(error.message.toString())



                    })

        }else{
            view.internetError(false)
        }


    }

    override fun searchMealsByName(name: String) {
        if (view.isInternetOrNo()){

            view.allMealsLoadingState(true)

            disposable=repository.searchMealsByName( name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response->

                    view.allMealsLoadingState(false)

                    when(response.code()){


                        in 200 .. 202->{

                            response.body()?.let {

                                if (it.meals != null) {
                                    if (it.meals.isNotEmpty()) {

                                        view.showAllMealsApi(it)


                                    }

                                    }else {

                                    view.showEmptyList()

                                }
                            }

                        }

                    }




                },



                    {error->

                        view.allMealsLoadingState(false)
                        view.serverError(error.message.toString())



                    })

        }else{
            view.internetError(false)
        }
    }

    override fun callFilterByCategoryApi(categoryName: String) {
        if (view.isInternetOrNo()){

            view.allMealsLoadingState(true)

            disposable=repository.filterByCategory(categoryName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response->

view.allMealsLoadingState(false)
                   when(response.code()){

                       in 200 .. 202->{

                           response.body().let {

                               if (it?.meals!!.isNotEmpty()){

                                   view.showAllMealsApi(it)


                               }



                           }

                       }



                   }





                },






                    {error->



                    view.allMealsLoadingState(false)
                    view.serverError(error.message.toString())



                })



        }else{
            view.internetError(false)
        }
    }


}
