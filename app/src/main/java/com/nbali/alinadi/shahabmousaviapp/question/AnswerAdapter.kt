package com.nbali.alinadi.shahabmousaviapp.question

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Answer

class AnswerAdapter(var context: Context,var list:List<Answer>): RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.answer_item,parent,false)
        return AnswerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.txtId.text = list[position].question_id
        holder.txtTitle.text = list[position].question_title

        if(list[position].question_status == "0"){

            holder.wrongTypeFrame.visibility = View.GONE
            holder.image.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.user))
            holder.answerParent.visibility = View.GONE

        }else if(list[position].question_status == "1"){

            holder.wrongTypeFrame.visibility = View.GONE
            holder.image.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.support))
            holder.answerParent.visibility = View.VISIBLE
            holder.txtAnswer.text = list[position].question_answer
            holder.txtAnswerDate.text = list[position].question_updated_app

        }else if(list[position].question_status == "2"){

            holder.image.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.support))
            holder.wrongTypeFrame.visibility = View.VISIBLE
            holder.answerParent.visibility = View.GONE

        }else{
            holder.wrongTypeFrame.visibility = View.GONE
            holder.image.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.user))
            holder.answerParent.visibility = View.GONE
        }

        holder.txtText.text = list[position].question_text

        if(list[position].question_product != ""){
            holder.txtProduct.text = list[position].question_product
        }else{
            holder.txtProduct.visibility = View.GONE
        }

        holder.txtDate.text = list[position].question_created_app
        if(list[position].question_type == "0"){
            holder.txtType.text = "مشاوره"
        }else{
            holder.txtType.text = "تخصصی"
        }
    }

    inner class AnswerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent=itemView.findViewById<RelativeLayout>(R.id.rel_answerItem_parent)
        var answerParent=itemView.findViewById<RelativeLayout>(R.id.rl_answer_answer_parent)
        var image=itemView.findViewById<ImageView>(R.id.img_answerItem_logo)
        var txtTitle=itemView.findViewById<TextView>(R.id.txt_answerItem_title)
        var txtText=itemView.findViewById<TextView>(R.id.txt_answerItem_text)
        var txtProduct=itemView.findViewById<TextView>(R.id.txt_answerItem_product)
        var txtType=itemView.findViewById<TextView>(R.id.txt_answerItem_type)
        var txtDate=itemView.findViewById<TextView>(R.id.txt_answerItem_date)
        var txtAnswerDate=itemView.findViewById<TextView>(R.id.txt_answerItem_answer_date)
        var txtId=itemView.findViewById<TextView>(R.id.txt_answerItem_id)
        var txtAnswer=itemView.findViewById<TextView>(R.id.txt_answerItem_answer)
        var wrongTypeFrame=itemView.findViewById<LinearLayout>(R.id.linear_answerItem_wrongTypeFrame)
    }
}