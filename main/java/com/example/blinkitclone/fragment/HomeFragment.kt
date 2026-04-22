package com.example.blinkitclone.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blinkitclone.R
import com.example.blinkitclone.adapter.ProductAdapter
import com.example.blinkitclone.model.Product

class HomeFragment:Fragment() {

    lateinit var adapter:ProductAdapter
    lateinit var productList:List<Product>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_home,container,false)

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerView)
        val search = view.findViewById<EditText>(R.id.searchBar)

        productList = listOf(
            Product(1,"Milk",55.0,R.drawable.milk),
            Product(2,"Bread",40.0,R.drawable.bread),
            Product(3,"Eggs",75.0,R.drawable.eggs),
            Product(4,"Banana",60.0,R.drawable.banana),
            Product(5,"Apple",120.0,R.drawable.apples)
        )

        adapter = ProductAdapter(productList)

        recycler.layoutManager = GridLayoutManager(requireContext(),2)
        recycler.adapter = adapter

        search.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val filtered = productList.filter {
                    it.name.contains(s.toString(),true)
                }

                recycler.adapter = ProductAdapter(filtered)
            }
        })

        return view
    }
}