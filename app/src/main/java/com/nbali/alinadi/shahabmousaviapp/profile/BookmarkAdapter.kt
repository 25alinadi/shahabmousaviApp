package com.nbali.alinadi.shahabmousaviapp.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mikhaellopez.circularimageview.CircularImageView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.room.RProduct
import com.squareup.picasso.Picasso

class BookmarkAdapter(var context:Context,var list:List<RProduct>, var onBookmarkItemClick:(item:RProduct)->Unit): RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.bookmark_item,parent,false)
        return BookmarkViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        Picasso.get().load(list[position].image).placeholder(R.drawable.load_img).into(holder.image)
        holder.txtTile.text = list[position].name
        holder.txtAmount.text = list[position].amount_app
        holder.parent.setOnClickListener{
            onBookmarkItemClick(list[position])
        }
    }

    inner class BookmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent = itemView.findViewById<CardView>(R.id.bookmark_parent_rl)!!
        var image = itemView.findViewById<CircularImageView>(R.id.bookmark_image_iv)!!
        var txtTile = itemView.findViewById<TextView>(R.id.bookmark_title_tv)!!
        var txtAmount = itemView.findViewById<TextView>(R.id.bookmark_amount_tv)!!
    }
}