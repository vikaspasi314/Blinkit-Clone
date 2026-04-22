package com.example.blinkitclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.blinkitclone.fragment.AccountFragment
import com.example.blinkitclone.fragment.CartFragment
import com.example.blinkitclone.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNav)

        loadFragment(HomeFragment())

        bottomNav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> loadFragment(HomeFragment())
                R.id.cart -> loadFragment(CartFragment())
                R.id.account -> loadFragment(AccountFragment())

            }

            true
        }

        updateCartBadge()
    }

    fun updateCartBadge(){
        val badge = bottomNav.getOrCreateBadge(R.id.cart)
        badge.isVisible = true
        badge.number = com.example.blinkitclone.utils.CartManager.cartItems.size
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .commit()
    }
}