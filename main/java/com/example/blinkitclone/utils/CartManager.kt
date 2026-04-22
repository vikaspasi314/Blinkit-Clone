package com.example.blinkitclone.utils

import com.example.blinkitclone.model.Product

object CartManager {

    val cartItems = mutableListOf<Product>()

    fun add(product: Product) {
        val item = cartItems.find { it.id == product.id }

        if (item == null) {
            product.quantity = 1
            cartItems.add(product)
        } else {
            item.quantity++
        }
    }

    fun remove(product: Product) {
        val item = cartItems.find { it.id == product.id }

        item?.let {
            it.quantity--
            if (it.quantity <= 0) {
                cartItems.remove(it)
                it.quantity = 0
            }
        }
    }

    fun total(): Double {
        return cartItems.sumOf { it.price * it.quantity }
    }
}