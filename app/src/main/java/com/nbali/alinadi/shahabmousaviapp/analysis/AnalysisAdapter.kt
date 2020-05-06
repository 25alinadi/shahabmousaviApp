package com.nbali.alinadi.shahabmousaviapp.analysis

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Analysis


class AnalysisAdapter(var context: Context,var list:List<Analysis>,var onClickItemAnalysis:(item:Analysis)->Unit): RecyclerView.Adapter<AnalysisAdapter.AnalysisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalysisViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.analysis_item,parent,false)
        return AnalysisViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AnalysisViewHolder, position: Int) {
        holder.txtId.text = list[position].analysis_id
        holder.txtTitle.text = "سبد تحلیل ( #"+list[position].analysis_id+" )"
        holder.txtCreateDate.text = "تاریخ ایجاد : " + list[position].analysis_created_at
        holder.txtUpdateDate.text = "تاریخ بروزرسانی : " + list[position].analysis_updated_at

        when(list[position].analysis_status){
            "1" -> {
                holder.txtStatus.text = "ارسال نتیجه"
                holder.txtStatus.setTextColor(ContextCompat.getColor(context,R.color.white))
                holder.cvStatus.setCardBackgroundColor(ContextCompat.getColor(context,R.color.steel_blue))
                holder.descParent.visibility = View.VISIBLE
                holder.txtDescription.text = "توضیح کلی سبد : " + list[position].analysis_description
            }

            "2" -> {
                holder.txtStatus.text = "در حال بررسی"
                holder.descParent.visibility = View.GONE
                holder.txtStatus.setTextColor(ContextCompat.getColor(context,R.color.prussian_blue))
                holder.cvStatus.setCardBackgroundColor(ContextCompat.getColor(context,R.color.yellow_primary))
            }

            "3" -> {
                holder.txtStatus.text = "بسته شد"
                holder.txtStatus.setTextColor(ContextCompat.getColor(context,R.color.darkgray2))
                holder.cvStatus.setCardBackgroundColor(ContextCompat.getColor(context,R.color.cool_gray))
                holder.descParent.visibility = View.VISIBLE
                holder.txtDescription.text = "توضیح کلی سبد : " + list[position].analysis_description
            }
        }

        holder.parent.setOnClickListener{
            onClickItemAnalysis(list[position])
        }
    }

    inner class AnalysisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent=itemView.findViewById<RelativeLayout>(R.id.rel_analysisItem_parent)
        var descParent=itemView.findViewById<RelativeLayout>(R.id.rl_answer_answer_parent)
        var txtId=itemView.findViewById<TextView>(R.id.txt_analysisItem_id)
        var txtTitle=itemView.findViewById<TextView>(R.id.txt_analysisItem_title)
        var txtCreateDate=itemView.findViewById<TextView>(R.id.txt_analysisItem_createdate)
        var txtUpdateDate=itemView.findViewById<TextView>(R.id.txt_analysisItem_updatedate)
        var txtStatus=itemView.findViewById<TextView>(R.id.txt_analysisItem_status)
        var cvStatus=itemView.findViewById<CardView>(R.id.cv_analysisItem_status)
        var txtDescription=itemView.findViewById<TextView>(R.id.txt_analysisItem_description)
    }

}