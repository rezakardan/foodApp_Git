package com.example.foodapplication.data.db

import android.app.TaskStackBuilder
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foodapplication.utils.FOOD_TABLE_DATABASE
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface FavoriteDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFood(entity: FavoriteEntity):Completable


    @Delete
    fun deleteFood(entity: FavoriteEntity):Completable




    @Query("SELECT* FROM $FOOD_TABLE_DATABASE")
    fun getAllFoods():Observable<MutableList<FavoriteEntity>>



    @Query("SELECT EXISTS(SELECT 1 FROM $FOOD_TABLE_DATABASE WHERE id= :id)")
fun existFood(id:Int):Observable<Boolean>




}