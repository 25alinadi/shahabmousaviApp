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

class AdviceAdminAdapter(var context:Context,var list: List<Timing>,var onClickItemTimingStatus:(id:Int,status:Int)->Unit): RecyclerView.Adapter<AdviceAdminAdapter.AdviceAdminViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdviceAdminViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.advice_admin_item,parent,false)
        return AdviceAdminViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdviceAdminViewHolder, position: Int) {
        holder.txtDay.text = list[position].timing_day
        holder.txtDate.text = list[position].timing_date
        holder.txtTime.text = list[position].timing_time
        holder.txtUser.text = list[position].timing_user

        holder.cvDone.setOnClickListener{
            onClickItemTimingStatus(list[position].timing_id.toInt(),1)
        }

        holder.cvCancle.setOnClickListener{
            onClickItemTimingStatus(list[position].timing_id.toInt(),2)
        }
    }

    inner class AdviceAdminViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtDay=itemView.findViewById<TextView>(R.id.txt_adviceadminItem_day)!!
        var txtDate=itemView.findViewById<TextView>(R.id.txt_adviceadminItem_date)!!
        var txtTime=itemView.findViewById<TextView>(R.id.txt_adviceadminItem_time)!!
        var txtUser=itemView.findViewById<TextView>(R.id.txt_adviceadminItem_userName)!!
        var cvDone=itemView.findViewById<CardView>(R.id.cv_adviceadminItem_done)!!
        var cvCancle=itemView.findViewById<CardView>(R.id.cv_adviceadminItem_cancle)!!
    }
}