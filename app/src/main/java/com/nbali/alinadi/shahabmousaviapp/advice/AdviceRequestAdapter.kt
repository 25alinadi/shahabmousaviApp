package com.nbali.alinadi.shahabmousaviapp.advice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Timing

class AdviceRequestAdapter(var context: Context,var list:ArrayList<Timing>,var onClickItemTiming:(id:String)->Unit): RecyclerView.Adapter<AdviceRequestAdapter.AdviceRequestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdviceRequestViewHolder {
       var view = LayoutInflater.from(context).inflate(R.layout.advice_request_item,parent,false)
        return AdviceRequestViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdviceRequestViewHolder, position: Int) {
        holder.txtDay.text = list[position].timing_day
        holder.txtTime.text = list[position].timing_time
        holder.txtDate.text = list[position].timing_date

        holder.btnInsert.setOnClickListener {
            onClickItemTiming(list[position].timing_id)
        }
    }

    inner class AdviceRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtDay=itemView.findViewById<TextView>(R.id.txt_requestItem_day)
        var txtDate=itemView.findViewById<TextView>(R.id.txt_requestItem_date)
        var txtTime=itemView.findViewById<TextView>(R.id.txt_requestItem_time)
        var btnInsert=itemView.findViewById<TextView>(R.id.txt_requestItem_request)
    }
}