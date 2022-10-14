package com.trr1ckster.deliveryfoodtestapp.data.api

import com.trr1ckster.deliveryfoodtestapp.data.model.Pizza
import retrofit2.Response
import retrofit2.http.GET


interface Api {

    @GET("pizzas")
    suspend fun getData(): Response<List<Pizza>>
}