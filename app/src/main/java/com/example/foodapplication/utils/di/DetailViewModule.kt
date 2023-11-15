package com.example.foodapplication.utils.di

import androidx.fragment.app.Fragment
import com.example.foodapplication.ui.detail.DetailContracts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Inject

@Module
@InstallIn(FragmentComponent::class)
class DetailViewModule {


    @Provides
    fun detailView(fragment:Fragment):DetailContracts.View{

        return fragment as DetailContracts.View



    }




}