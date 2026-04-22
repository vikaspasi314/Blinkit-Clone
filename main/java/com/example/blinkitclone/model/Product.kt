package com.example.blinkitclone.model


data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val image: Int,
    var quantity: Int = 0
)