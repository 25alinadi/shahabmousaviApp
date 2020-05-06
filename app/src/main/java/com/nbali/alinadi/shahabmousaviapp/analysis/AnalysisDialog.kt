package com.nbali.alinadi.shahabmousaviapp.analysis

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.nbali.alinadi.shahabmousaviapp.R

class AnalysisDialog:DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(context)
        var view = LayoutInflater.from(context).inflate(R.layout.dialog_analysis,null)
        var btnLink = view.findViewById<Button>(R.id.btn_analysisDialog_sendBasket)

        btnLink.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://shahabmousavi.com/sm-accounts?panel=analysis"))
            startActivity(intent)
            dismiss()
        }

        builder.setView(view)
        return builder.create()
    }
}