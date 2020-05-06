package com.nbali.alinadi.shahabmousaviapp.analysis

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.AnalysisRow

class AnalysisRowAdapter(var context:Context,var list:List<AnalysisRow>): RecyclerView.Adapter<AnalysisRowAdapter.AnalysisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalysisViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.analysis_row_item,parent,false)
        return AnalysisViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AnalysisViewHolder, position: Int) {
        holder.txtSymbol.text = list[position].row_symbol
        holder.txtNumShare.text = "تعداد سهام : "+list[position].row_number_share
        holder.txtAverage.text = "میانگین خرید : "+list[position].row_average_buy
        holder.txtPercentShare.text = "درصد سهام : "+list[position].row_percent_share

        if(list[position].row_description != ""){
            holder.txtDescParent.visibility = View.VISIBLE
            holder.txtDescription.text = list[position].row_description
        }else{
            holder.txtDescParent.visibility = View.GONE
        }
    }

    inner class AnalysisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtSymbol = itemView.findViewById<TextView>(R.id.txt_rowItem_symbol)!!
        var txtNumShare = itemView.findViewById<TextView>(R.id.txt_rowItem_num_share)!!
        var txtPercentShare = itemView.findViewById<TextView>(R.id.txt_rowItem_percent_share)!!
        var txtAverage = itemView.findViewById<TextView>(R.id.txt_rowItem_average_buy)!!
        var txtDescParent = itemView.findViewById<RelativeLayout>(R.id.rl_rowItem_desc_parent)!!
        var txtDescription = itemView.findViewById<TextView>(R.id.txt_rowItem_description)!!
    }
}