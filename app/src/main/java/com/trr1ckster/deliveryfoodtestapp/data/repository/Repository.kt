package com.trr1ckster.deliveryfoodtestapp.data.repository

import androidx.lifecycle.LiveData
import com.trr1ckster.deliveryfoodtestapp.data.api.RetrofitInstance
import com.trr1ckster.deliveryfoodtestapp.data.db.PizzaDatabase
import com.trr1ckster.deliveryfoodtestapp.data.model.Pizza
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Repository(private val database: PizzaDatabase) {

    val pizzaData: LiveData<List<Pizza>> = database.pizzaDao.getPizza()

    suspend fun refreshData() {
        withContext(Dispatchers.IO) {
            val pizza = RetrofitInstance.pizzaApi.getData()
            database.pizzaDao.insertAll(pizza)
        }
    }
}