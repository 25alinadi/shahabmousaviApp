package com.nbali.alinadi.shahabmousaviapp.subscribe

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Answer
import com.nbali.alinadi.shahabmousaviapp.models.Subscribe

class SubscribeDialog():DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(context!!)
        var view = LayoutInflater.from(context).inflate(R.layout.dialog_subscribe,null)
        var btnPay = view.findViewById<Button>(R.id.btn_subscribeDialog_pay)
        var btnCancle = view.findViewById<Button>(R.id.btn_subscribeDialog_cancle)

        btnPay.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://shahabmousavi.com/sm-accounts?panel=subscribes"))
            startActivity(intent)
            dismiss()
        }

        btnCancle.setOnClickListener{
            dismiss()
        }

        builder.setView(view)
        return builder.create()
    }
}