package com.nbali.alinadi.shahabmousaviapp.profile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.ProfileAccount
import kotlinx.android.synthetic.main.profile_account_item.view.*

class AccountAdapter(var context: Context, var list:MutableList<ProfileAccount>,var onAccountItemClick:(title:String)->Unit): RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.profile_account_item,parent,false)
        return AccountViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.txtTitle.text = list[position].title
        holder.icon.setImageDrawable(ContextCompat.getDrawable(context,list[position].icon))
        holder.parent.setOnClickListener{
            onAccountItemClick(list[position].title)
        }
    }

    inner class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent = itemView.findViewById<RelativeLayout>(R.id.constraint_accountItem_parent)
        var txtTitle = itemView.findViewById<TextView>(R.id.txt_accountItem_title)
        var icon = itemView.findViewById<ImageView>(R.id.img_accountItem_icon)
    }
}