package com.example.blinkitclone.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blinkitclone.OrderPlacedActivity
import com.example.blinkitclone.R
import com.example.blinkitclone.adapter.ProductAdapter
import com.example.blinkitclone.utils.CartManager

class CartFragment : Fragment() {

    lateinit var totalText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        val recycler = view.findViewById<RecyclerView>(R.id.cartRecycler)
        val orderBtn = view.findViewById<Button>(R.id.orderBtn)
        totalText = view.findViewById(R.id.totalText)

        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = ProductAdapter(CartManager.cartItems)

        updateTotal()

        orderBtn.setOnClickListener {

            if (CartManager.cartItems.isNotEmpty()) {

                CartManager.cartItems.clear()
                updateTotal()

                startActivity(
                    Intent(requireContext(), OrderPlacedActivity::class.java)
                )
            }
        }

        return view
    }

    private fun updateTotal() {
        totalText.text = "Total: ₹${CartManager.total()}"
    }

    override fun onResume() {
        super.onResume()
        updateTotal()
    }
}