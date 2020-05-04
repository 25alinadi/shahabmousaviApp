package com.nbali.alinadi.shahabmousaviapp.question

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Answer

class AdminAnswersAdapter(var context: Context, var list:List<Answer>,var onAdminAnswerItemClick:(answer:Answer)->Unit) : RecyclerView.Adapter<AdminAnswersAdapter.AdminAnswersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminAnswersViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.noanswer_item,parent,false)
        return AdminAnswersViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: AdminAnswersViewHolder, position: Int) {
        holder.txtId.text = list[position].question_id
        holder.txtTitle.text = list[position].question_title
        holder.image.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.user))
        holder.txtText.text = list[position].question_text

        holder.txtUserName.text = list[position].display_name

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

        holder.btnReturnedAnswer.setOnClickListener{
            onAdminAnswerItemClick(list[position])
        }

        holder.btnAnswerQuestion.setOnClickListener{
            onAdminAnswerItemClick(list[position])
        }

    }

    inner class AdminAnswersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var parent=itemView.findViewById<RelativeLayout>(R.id.rel_noanswerItem_parent)!!
        var image=itemView.findViewById<ImageView>(R.id.img_noanswerItem_logo)!!
        var txtTitle=itemView.findViewById<TextView>(R.id.txt_noanswerItem_title)!!
        var txtText=itemView.findViewById<TextView>(R.id.txt_noanswerItem_text)!!
        var txtProduct=itemView.findViewById<TextView>(R.id.txt_noanswerItem_product)!!
        var txtType=itemView.findViewById<TextView>(R.id.txt_noanswerItem_type)!!
        var txtDate=itemView.findViewById<TextView>(R.id.txt_noanswerItem_date)!!
        var txtId=itemView.findViewById<TextView>(R.id.txt_noanswerItem_id)!!
        var txtUserName=itemView.findViewById<TextView>(R.id.txt_noanswerItem_userName)!!
        var btnAnswerQuestion=itemView.findViewById<Button>(R.id.btn_noanswer_answer_question)!!
        var btnReturnedAnswer=itemView.findViewById<Button>(R.id.btn_noanswer_returned_question)!!
    }
}