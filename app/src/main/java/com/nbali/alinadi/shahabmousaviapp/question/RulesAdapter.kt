package com.nbali.alinadi.shahabmousaviapp.question

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Rule

class RulesAdapter(var context:Context,var list:List<Rule>): RecyclerView.Adapter<RulesAdapter.RulesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RulesViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.rule_item,parent,false)
        return RulesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RulesViewHolder, position: Int) {
        holder.txtRule.text = list[position].rule_text
    }

    inner class RulesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtRule = itemView.findViewById<TextView>(R.id.txt_rulesItem_title)
    }
}