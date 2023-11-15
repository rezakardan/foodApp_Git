package com.example.foodapplication.utils.di

import androidx.fragment.app.Fragment
import com.example.foodapplication.ui.favorite.FavoriteContracts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


@Module
@InstallIn(FragmentComponent::class)
class FavoriteViewModule {


    @Provides
    fun provideFavoriteView(fragment: Fragment):FavoriteContracts.View{


        return fragment as FavoriteContracts.View


    }



}