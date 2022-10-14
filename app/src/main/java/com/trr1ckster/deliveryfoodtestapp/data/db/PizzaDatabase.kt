package com.trr1ckster.deliveryfoodtestapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.trr1ckster.deliveryfoodtestapp.data.model.Pizza

@Database(
    entities = [Pizza::class],
    version = 1
)

abstract class PizzaDatabase : RoomDatabase() {

    abstract val pizzaDao: PizzaDao
}

private lateinit var INSTANCE: PizzaDatabase

fun getDatabase(context: Context): PizzaDatabase {
    synchronized(PizzaDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                PizzaDatabase::class.java,
                "pizza_db"
            ).build()
        }
    }
    return INSTANCE
}