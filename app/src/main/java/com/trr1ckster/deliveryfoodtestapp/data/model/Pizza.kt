package com.trr1ckster.deliveryfoodtestapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Pizza(
    @PrimaryKey
    val id: String,
    val img: String,
    val name: String,
    val dsc: String,
    val price: Double,
    val rate: Long,
    val country: String
)
