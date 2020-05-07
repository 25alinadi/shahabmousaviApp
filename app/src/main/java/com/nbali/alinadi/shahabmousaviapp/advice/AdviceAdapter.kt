package com.nbali.alinadi.shahabmousaviapp.advice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Advice

class AdviceAdapter(var context: Context,var list:List<Advice>): RecyclerView.Adapter<AdviceAdapter.AdviceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdviceViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.advice_item,parent,false)
        return AdviceViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdviceViewHolder, position: Int) {
        holder.txtDay.text = list[position].advice_day
        holder.txtDate.text = "( "+list[position].advice_date+" )"
        holder.txtTime.text = list[position].advice_time
        holder.txtCreateDate.text = list[position].advice_create_date

        when(list[position].advice_status){
            "0" -> {
                holder.txtStatus.text = "در حال بررسی"
                holder.txtStatus.setTextColor(ContextCompat.getColor(context,R.color.prussian_blue))
                holder.cvStatus.setCardBackgroundColor(ContextCompat.getColor(context,R.color.yellow_primary))
            }
            "1" -> {
                holder.txtStatus.text = "تایید شد"
                holder.txtStatus.setTextColor(ContextCompat.getColor(context,R.color.white))
                holder.cvStatus.setCardBackgroundColor(ContextCompat.getColor(context,R.color.steel_blue))
            }
            "2" -> {
                holder.txtStatus.text = "کنسل شد"
                holder.txtStatus.setTextColor(ContextCompat.getColor(context,R.color.white))
                holder.cvStatus.setCardBackgroundColor(ContextCompat.getColor(context,R.color.crismon))
            }
            "3" -> {
                holder.txtStatus.text = "انجام شد"
                holder.txtStatus.setTextColor(ContextCompat.getColor(context,R.color.white))
                holder.cvStatus.setCardBackgroundColor(ContextCompat.getColor(context,R.color.steel_blue))
            }
        }
    }

    inner class AdviceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtDay=itemView.findViewById<TextView>(R.id.txt_adviceItem_day)
        var txtDate=itemView.findViewById<TextView>(R.id.txt_adviceItem_date)
        var txtTime=itemView.findViewById<TextView>(R.id.txt_adviceItem_time)
        var txtStatus=itemView.findViewById<TextView>(R.id.txt_adviceItem_status)
        var cvStatus=itemView.findViewById<CardView>(R.id.cv_adviceItem_status)
        var txtCreateDate=itemView.findViewById<TextView>(R.id.txt_adviceItem_createdate)
    }
}