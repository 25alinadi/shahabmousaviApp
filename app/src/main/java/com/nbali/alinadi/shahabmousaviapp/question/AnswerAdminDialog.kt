package com.nbali.alinadi.shahabmousaviapp.question

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Answer

class AnswerAdminDialog(var answer:Answer,var onBtnAnswerClick:(id:String,answer:String)->Unit):DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(context!!)
        var view = LayoutInflater.from(context).inflate(R.layout.dialog_answer_admin,null)
        var txtTitle =  view.findViewById<TextView>(R.id.txt_answerDialog_title)
        var edtAnswer =  view.findViewById<EditText>(R.id.edt_answerDialog_answer)
        var btnAnswer =  view.findViewById<Button>(R.id.btn_answerDialog_sendAnswer)

        txtTitle.text = answer.question_title

        btnAnswer.setOnClickListener{
            onBtnAnswerClick(answer.question_id,edtAnswer.text.toString())
        }

        builder.setView(view)
        return builder.create()
    }
}