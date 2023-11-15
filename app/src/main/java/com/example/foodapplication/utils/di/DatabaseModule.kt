package com.example.foodapplication.utils.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodapplication.data.db.FavoriteDao
import com.example.foodapplication.data.db.FavoriteDatabase
import com.example.foodapplication.data.db.FavoriteEntity
import com.example.foodapplication.utils.FOOD_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, FavoriteDatabase::class.java, FOOD_DATABASE)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()


    @Provides
    @Singleton
    fun provideDao(db: FavoriteDatabase) = db.favoriteDao()

    @Provides
    @Singleton
    fun provideEntity() = FavoriteEntity()

}