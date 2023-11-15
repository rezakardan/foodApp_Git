package com.example.foodapplication.utils.di

import androidx.fragment.app.Fragment
import com.example.foodapplication.ui.home.HomeContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


@Module
@InstallIn(FragmentComponent::class)
class HomeViewModule {



@Provides
    fun provideViewModule(fragment: Fragment):HomeContract.View{


        return fragment as HomeContract.View




    }





}