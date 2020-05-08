package com.nbali.alinadi.shahabmousaviapp.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.ProfileAccount
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class AccountFragment : Fragment() {
    lateinit var viewModel : ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_account, container, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_account_list)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = AccountAdapter(context!!,createMenuList()) {
            when(it){
                "حساب کاربری" -> {
                    var transaction = activity!!.supportFragmentManager.beginTransaction()
                    Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.Landing)
                    transaction.replace(R.id.main_fragment_frame,EditProfileFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }

                "نشان شده ها" -> {
                    var transaction = activity!!.supportFragmentManager.beginTransaction()
                    Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.Landing)
                    transaction.replace(R.id.main_fragment_frame,BookmarkFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }

                "اشتراک گذاری برنامه" -> {
                    var intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_TEXT,"")
                    startActivity(Intent.createChooser(intent,"انتسار اپلیکیشن شهاب موسوی"))
                    startActivity(intent)
                }
            }
        }
        var txtLogin = view.findViewById<TextView>(R.id.txt_account_login)

        if(viewModel.getToken() == ""){
            txtLogin.visibility = View.VISIBLE
            recycler.visibility = View.GONE
        }else{
            txtLogin.visibility = View.GONE
            recycler.visibility = View.VISIBLE
        }

        txtLogin.setOnClickListener {
            var transaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
            transaction.replace(R.id.main_fragment_frame,LoginFragment("account"))
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

    private fun createMenuList():MutableList<ProfileAccount> {
        var mutableList = mutableListOf<ProfileAccount>()

        var menu1 = ProfileAccount("حساب کاربری",R.drawable.account_card_details)
        mutableList.add(menu1)
        var menu2 = ProfileAccount("نشان شده ها",R.drawable.bookmark_plus)
        mutableList.add(menu2)
        var menu3 = ProfileAccount("اشتراک گذاری برنامه",R.drawable.share_variant)
        mutableList.add(menu3)

        return mutableList
    }

}
