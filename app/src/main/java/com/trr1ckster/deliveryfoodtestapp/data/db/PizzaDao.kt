package com.trr1ckster.deliveryfoodtestapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.trr1ckster.deliveryfoodtestapp.data.model.Pizza

@Dao
interface PizzaDao {

    @Query("select * from pizza")
    fun getPizza(): LiveData<List<Pizza>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(pizza: List<Pizza>)
}