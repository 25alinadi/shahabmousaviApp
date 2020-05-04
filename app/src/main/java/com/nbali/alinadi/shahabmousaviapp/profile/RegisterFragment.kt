package com.nbali.alinadi.shahabmousaviapp.profile

import android.content.Context
import android.content.SharedPreferences
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
import com.nbali.alinadi.shahabmousaviapp.question.QuestionFragment
import com.nbali.alinadi.shahabmousaviapp.utils.Utils
import com.nbali.alinadi.shahabmousaviapp.utils.Utils.isEmailValid

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment(var destination:String) : Fragment() {
    private lateinit var viewModel: ProfileViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_register, container, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var edtFirstName = view.findViewById<EditText>(R.id.edt_register_firstName)
        var edtLastName = view.findViewById<EditText>(R.id.edt_register_lastName)
        var edtEmail = view.findViewById<EditText>(R.id.edt_register_email)
        var edtPassword = view.findViewById<EditText>(R.id.edt_register_pass)
        var edtPhone = view.findViewById<EditText>(R.id.edt_register_mobile)
        var rgGender = view.findViewById<RadioGroup>(R.id.rg_register_gender)
        var btnRegister = view.findViewById<Button>(R.id.btn_register_register)

        btnRegister.setOnClickListener{
            if( edtFirstName.text.isEmpty() || edtLastName.text.isEmpty()){
                Toast.makeText(context, "پر کردن تمامی فیلدها الزامی است", Toast.LENGTH_SHORT).show()
            }else{
                if (!isEmailValid(edtEmail.text.toString())) {
                    Toast.makeText(context, "ایمیل معتبر نیست", Toast.LENGTH_SHORT).show()
                }else{
                    if (edtPassword.text.length < 4 || edtPassword.text.isEmpty()) {
                        Toast.makeText(context, "پسود باید حداقل 4 کاراکتر باشد", Toast.LENGTH_SHORT).show()
                    } else {
                        if(edtPhone.text.length < 11 || edtPhone.text.length > 11 || edtPhone.text.isEmpty()){

                        }else{
                            var gender=0
                            var selectedId=rgGender.checkedRadioButtonId
                            var radioButton=view.findViewById<RadioButton>(selectedId)
                            var text=radioButton.text
                            if(text.equals("زن")){
                                gender = 1
                            }

                            viewModel.registerUser(edtFirstName.text.toString(),edtLastName.text.toString(),edtEmail.text.toString(),edtPassword.text.toString(),edtPhone.text.toString(),gender).observe(this,
                                Observer {
                                    if(it.message.equals("ثبت نام شما با موفقیت انجام شد") && !it.token.equals("")){
                                        viewModel.createToken(it.token,it.fullName,it.role)
                                        Toast.makeText(context,it.message, Toast.LENGTH_SHORT).show()
                                        if(destination == "account"){
                                            var transaction = activity!!.supportFragmentManager.beginTransaction()
                                            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.FadeInUp)
                                            transaction.replace(R.id.main_fragment_frame,ProfileFragment())
                                            transaction.commit()
                                        }else{
                                            var transaction = activity!!.supportFragmentManager.beginTransaction()
                                            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.FadeInUp)
                                            transaction.replace(R.id.main_fragment_frame,QuestionFragment())
                                            transaction.commit()
                                        }
                                    }else{
                                        Toast.makeText(context,it.message, Toast.LENGTH_SHORT).show()
                                    }
                                })
                        }
                    }
                }
            }
        }

        var btnBack = view.findViewById<ImageView>(R.id.register_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }


        return view
    }

}
