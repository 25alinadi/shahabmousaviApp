package com.nbali.alinadi.shahabmousaviapp.post

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mikhaellopez.circularimageview.CircularImageView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Product
import com.squareup.picasso.Picasso

class ProductAdapter(var context :Context,var list:List<Product>,var onClickItemProduct:(item:Product)->Unit): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Picasso.get().load(list[position].product_image).placeholder(R.drawable.load_img).into(holder.image)
        holder.txtTile.text = list[position].product_name
        holder.txtAmount.text = list[position].product_amount_app
        holder.parent.setOnClickListener{
            onClickItemProduct(list[position])
        }
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent = itemView.findViewById<CardView>(R.id.product_parent_rl)!!
        var image = itemView.findViewById<CircularImageView>(R.id.product_image_iv)!!
        var txtTile = itemView.findViewById<TextView>(R.id.product_title_tv)!!
        var txtAmount = itemView.findViewById<TextView>(R.id.product_amount_tv)!!
    }
}