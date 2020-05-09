package com.nbali.alinadi.shahabmousaviapp.profile

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

class SignoutDialog:DialogFragment() {

    lateinit var viewModel: ProfileViewModel
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(context)
        var view = LayoutInflater.from(context).inflate(R.layout.dialog_signout,null)
        var viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        var btnYes = view.findViewById<Button>(R.id.btn_signoutDialog_done)
        var btnNo = view.findViewById<Button>(R.id.btn_signoutDialog_cancle)

        btnYes.setOnClickListener{
            viewModel.signOut()
            var transaction =  activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
            transaction.replace(R.id.main_fragment_frame,LoginFragment("account"))
            transaction.commit()
            dismiss()
        }

        btnNo.setOnClickListener{
            dismiss()
        }

        builder.setView(view)
        return builder.create()
    }
}