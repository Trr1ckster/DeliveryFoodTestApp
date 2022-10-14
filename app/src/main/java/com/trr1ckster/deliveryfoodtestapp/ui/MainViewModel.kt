package com.trr1ckster.deliveryfoodtestapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trr1ckster.deliveryfoodtestapp.data.api.RetrofitInstance
import com.trr1ckster.deliveryfoodtestapp.data.model.Pizza
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _pizzaLiveData: MutableLiveData<List<Pizza>> = MutableLiveData()
    val pizzaLiveData: LiveData<List<Pizza>> = _pizzaLiveData

    init {
        getPizzaData()
    }

    private fun getPizzaData() = viewModelScope.launch {
        try {
            _pizzaLiveData.value = RetrofitInstance.foodApi.getData().body()
        }
         catch (e: Exception) {
             Log.e("TAG","$e")
         }
    }

}