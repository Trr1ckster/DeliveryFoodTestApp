package com.trr1ckster.deliveryfoodtestapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.trr1ckster.deliveryfoodtestapp.data.db.getDatabase
import com.trr1ckster.deliveryfoodtestapp.data.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val pizzaRepository = Repository(getDatabase(application))

    val pizza = pizzaRepository.pizzaData

    init {
        getPizzaDataFromRepository()
    }

    private fun getPizzaDataFromRepository() = viewModelScope.launch {
        try {
            pizzaRepository.refreshData()
        } catch (e: Exception) {
            Log.e("TAG", "$e")
        }
    }

}