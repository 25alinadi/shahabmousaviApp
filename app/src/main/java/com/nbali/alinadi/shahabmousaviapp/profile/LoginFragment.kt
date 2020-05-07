package com.nbali.alinadi.shahabmousaviapp.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.analysis.AnalysisFragment
import com.nbali.alinadi.shahabmousaviapp.home.HomeFragment
import com.nbali.alinadi.shahabmousaviapp.question.QuestionFragment
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment(var destination:String) : Fragment() {

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var edtEmail = view.findViewById<EditText>(R.id.edt_login_email)
        var edtPassword = view.findViewById<EditText>(R.id.edt_login_pass)
        var btnLogin = view.findViewById<Button>(R.id.btn_login_login)
        var btnRegister = view.findViewById<Button>(R.id.btn_login_register)

        btnLogin.setOnClickListener{
            if(Utils.isEmailValid(edtEmail.text.toString()) ) {
                if(edtPassword.text.length > 4){
                    viewModel.loginUser(edtEmail.text.toString(),edtPassword.text.toString()).observe(this,
                        Observer {
                            if (it.message.equals("شما با موفقیت وارد شدید") && !it.token.equals("") && it.status.equals("success")){
                                viewModel.createToken(it.token,it.fullName,it.role)
                                Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                                when (destination) {
                                    "account" -> {
                                        var transaction = activity!!.supportFragmentManager.beginTransaction()
                                        Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.FadeInUp)
                                        transaction.replace(R.id.main_fragment_frame, ProfileFragment())
                                        transaction.commit()
                                    }
                                    "home" -> {
                                        var transaction = activity!!.supportFragmentManager.beginTransaction()
                                        Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame), animation = Techniques.FadeInUp)
                                        transaction.replace(R.id.main_fragment_frame, HomeFragment())
                                        transaction.commit()
                                    }
                                    "question" -> {
                                        var transaction = activity!!.supportFragmentManager.beginTransaction()
                                        Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.FadeInUp)
                                        transaction.replace(R.id.main_fragment_frame,QuestionFragment())
                                        transaction.commit()
                                    }
                                }
                            }else{
                                Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                            }
                        })
                }else{
                    Toast.makeText(context,"پسورد باید حداقل 4 کاراکتر باشد",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context,"ایمیل معتبر نیست",Toast.LENGTH_SHORT).show()
            }
        }

        btnRegister.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.FadeInUp)
            transaction.replace(R.id.main_fragment_frame,RegisterFragment(destination))
            transaction.addToBackStack(null)
            transaction.commit()
        }

        var btnBack = view.findViewById<ImageView>(R.id.login_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
