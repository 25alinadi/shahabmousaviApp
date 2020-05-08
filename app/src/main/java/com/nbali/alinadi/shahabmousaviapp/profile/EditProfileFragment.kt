package com.nbali.alinadi.shahabmousaviapp.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class EditProfileFragment : Fragment() {

    lateinit var viewModel: ProfileViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_edit_profile, container, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var txtEmail = view.findViewById<TextView>(R.id.txt_editProfile_email)
        var edtName = view.findViewById<EditText>(R.id.edt_editProfile_name)
        var edtFamily = view.findViewById<EditText>(R.id.edt_editProfile_family)
        var edtPhone = view.findViewById<EditText>(R.id.edt_editProfile_phone)
        var genderGroup = view.findViewById<RadioGroup>(R.id.rg_editProfile_radioGroup)
        var radioMan = view.findViewById<RadioButton>(R.id.radio_editProfile_man)
        var radioWoman = view.findViewById<RadioButton>(R.id.radio_editProfile_woman)
        var btnEdit = view.findViewById<Button>(R.id.btn_editProfile_edit)

        viewModel.userInfo().observe(this, Observer {
            txtEmail.text = it.email
            edtName.setText(it.firstName)
            edtFamily.setText(it.lastName)
            edtPhone.setText(it.phone)

            if (it.gender == 0) {
                radioMan.isChecked = true
            } else {
                radioWoman.isChecked = true
            }

            btnEdit.setOnClickListener{
                var gender = 0
                if (edtName.text.toString().isNotEmpty()
                    && edtFamily.text.toString().isNotEmpty()
                    && edtPhone.text.toString().isNotEmpty()
                ) {
                    var radioButtonId = genderGroup.checkedRadioButtonId
                    var checkedRadioButton = genderGroup.findViewById<RadioButton>(radioButtonId)
                    var radioButtonText = checkedRadioButton.text

                    if (radioButtonText == "زن") {
                        gender = 1
                    }
                    viewModel.updateProfile(
                        edtName.text.toString(),
                        edtFamily.text.toString(),
                        edtPhone.text.toString(), gender).observe(this, Observer {
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                        var transaction = activity!!.supportFragmentManager.popBackStack()
                        if (it.status == "success") {
                            viewModel.updateFullName(edtName.text.toString() + " " + edtFamily.text.toString())
                        }
                    })
                } else {
                    Toast.makeText(
                        context,
                        "نام و نام خانوادگی و شماره همراه نمی تواند خالی باشد",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        })

        var btnBack = view.findViewById<ImageView>(R.id.editProfile_action_bar_arrow_back)
        btnBack.setOnClickListener{
            Utils.customAnimation(view,animation = Techniques.SlideOutDown)
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
