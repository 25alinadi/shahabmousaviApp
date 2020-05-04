package com.nbali.alinadi.shahabmousaviapp.post

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mikhaellopez.circularimageview.CircularImageView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Post
import com.squareup.picasso.Picasso

class PostAdapter(var context:Context,var list:List<Post>,var onPostItemClick:(id:String?)->Unit) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.post_item,parent,false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        Picasso.get().load(list[position].post_image).placeholder(R.drawable.load_img).into(holder.image)
        holder.txtTitle.text = list[position].post_title
        holder.txtDate.text = "تاریخ انتشار : "+list[position].post_date

        holder.parent.setOnClickListener{
            onPostItemClick(list[position].post_id)
        }
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent = itemView.findViewById<CardView>(R.id.post_parent_rl)
        var txtTitle = itemView.findViewById<TextView>(R.id.post_title_tv)
        var image = itemView.findViewById<CircularImageView>(R.id.post_image_iv)
        var txtDate = itemView.findViewById<TextView>(R.id.post_date_tv)
    }
}