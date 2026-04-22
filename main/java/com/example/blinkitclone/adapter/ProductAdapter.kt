package com.example.blinkitclone.adapter

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.blinkitclone.MainActivity
import com.example.blinkitclone.R
import com.example.blinkitclone.model.Product
import com.example.blinkitclone.utils.CartManager

class ProductAdapter(private val list: List<Product>)
    : RecyclerView.Adapter<ProductAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.name)
        val price: TextView = view.findViewById(R.id.price)
        val add: Button = view.findViewById(R.id.addBtn)
        val minus: Button = view.findViewById(R.id.minusBtn)
        val qty: TextView = view.findViewById(R.id.qty)
        val image: ImageView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        val product = list[position]

        holder.name.text = product.name
        holder.price.text = "₹${product.price}"
        holder.qty.text = product.quantity.toString()
        holder.image.setImageResource(product.image)

        holder.add.setOnClickListener {
            CartManager.add(product)
            holder.qty.text = product.quantity.toString()
            notifyItemChanged(position)

            (holder.itemView.context as MainActivity).updateCartBadge()
        }

        holder.minus.setOnClickListener {
            CartManager.remove(product)
            holder.qty.text = product.quantity.toString()
            notifyItemChanged(position)

            (holder.itemView.context as MainActivity).updateCartBadge()
        }
    }

    override fun getItemCount() = list.size
}