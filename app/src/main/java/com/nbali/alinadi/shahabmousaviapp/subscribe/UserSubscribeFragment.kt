package com.nbali.alinadi.shahabmousaviapp.subscribe

import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableContainer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class UserSubscribeFragment : Fragment() {
    lateinit var viewModel: SubscribeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_user_subscribe, container, false)
        viewModel = ViewModelProvider(this).get(SubscribeViewModel::class.java)
        var parent = view.findViewById<RelativeLayout>(R.id.rel_usersubscribe_parent)
        var txtTitle = view.findViewById<TextView>(R.id.txt_usersubscribe_title)
        var txtDuration = view.findViewById<TextView>(R.id.txt_usersubscribe_duration)
        var txtQuestion = view.findViewById<TextView>(R.id.txt_usersubscribe_question)
        var txtCreateDate = view.findViewById<TextView>(R.id.txt_usersubscribe_createDate)
        var txtExpireDate = view.findViewById<TextView>(R.id.txt_usersubscribe_expireDate)
        var txtStatus = view.findViewById<TextView>(R.id.txt_usersubscribe_status)
        var emptyState = view.findViewById<LinearLayout>(R.id.ll_usersubscribe_emptyState)
        var imgInsert = view.findViewById<ImageView>(R.id.img_analysis_add_basket)


        viewModel.getUserSubscribe().observe(this, Observer {
            if(it.subscribe_title == ""){
                parent.visibility = View.GONE
                emptyState.visibility = View.VISIBLE
            }else{
                txtTitle.text = it.subscribe_title
                txtCreateDate.text = "تاریخ خرید : " + it.subscribe_created_at
                txtDuration.text = "مدت زمان : " + it.subscribe_duration + " روز"
                txtQuestion.text = "تعداد سوال : " + it.subscribe_question + " سوال"
                txtExpireDate.text = "تاریخ انقضا : " + it.subscribe_expired_at

                when(it.subscribe_status.toInt()){
                    0 -> {
                        txtStatus.text = "وضعیت : غیرفعال"
                        txtStatus.setTextColor(ContextCompat.getColor(context!!,R.color.white))
                        txtStatus.background = ContextCompat.getDrawable(context!!,R.drawable.shape_btn_crismon)
                    }

                    1 -> {
                        txtStatus.text = "وضعیت : فعال"
                        txtStatus.setTextColor(ContextCompat.getColor(context!!,R.color.white))
                        txtStatus.background = ContextCompat.getDrawable(context!!,R.drawable.shape_btn_crismon)
                    }

                    2 -> {
                        txtStatus.text = "وضعیت : منقضی شده"
                        txtStatus.setTextColor(ContextCompat.getColor(context!!,R.color.prussian_blue))
                        txtStatus.background = ContextCompat.getDrawable(context!!,R.drawable.shape_btn_yellow)
                    }
                }
            }
        })

        imgInsert.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
            transaction.replace(R.id.main_fragment_frame,SubscribeFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        var btnBack = view.findViewById<ImageView>(R.id.user_subscribe_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
