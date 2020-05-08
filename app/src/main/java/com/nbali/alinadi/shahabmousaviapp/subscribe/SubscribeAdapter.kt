package com.nbali.alinadi.shahabmousaviapp.subscribe

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Subscribe

class SubscribeAdapter(var context: Context,var list:List<Subscribe>,var onClickSaleBtn:(item:Subscribe)->Unit): RecyclerView.Adapter<SubscribeAdapter.SubscribeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscribeViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.subscribe_item,parent,false)
        return SubscribeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SubscribeViewHolder, position: Int) {
        holder.txtTitle.text = list[position].subscribe_title
        holder.txtDuration.text = list[position].subscribe_duration+" روز"
        holder.txtQuestion.text = list[position].subscribe_question+" سوال"
        holder.txtAmount.text = list[position].subscribe_amount_app
        holder.btnSale.setOnClickListener{
            onClickSaleBtn(list[position])
        }
    }

    inner class SubscribeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent = itemView.findViewById<CardView>(R.id.subscribe_parent_rl)!!
        var txtTitle = itemView.findViewById<TextView>(R.id.subscribe_title_tv)!!
        var txtDuration = itemView.findViewById<TextView>(R.id.subscribe_duration_tv)!!
        var txtQuestion = itemView.findViewById<TextView>(R.id.subscribe_question_tv)!!
        var txtAmount = itemView.findViewById<TextView>(R.id.subscribe_amount_tv)!!
        var btnSale = itemView.findViewById<Button>(R.id.subscribe_button_sale_btn)!!
    }
}