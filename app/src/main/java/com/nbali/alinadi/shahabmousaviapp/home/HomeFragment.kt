package com.nbali.alinadi.shahabmousaviapp.home

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.advice.AdviceAdminFragment
import com.nbali.alinadi.shahabmousaviapp.advice.AdviceFragment
import com.nbali.alinadi.shahabmousaviapp.analysis.AnalysisFragment
import com.nbali.alinadi.shahabmousaviapp.profile.LoginFragment
import com.nbali.alinadi.shahabmousaviapp.profile.ProfileViewModel
import com.nbali.alinadi.shahabmousaviapp.question.QuestionViewModel
import com.nbali.alinadi.shahabmousaviapp.subscribe.SubscribeFragment
import com.nbali.alinadi.shahabmousaviapp.subscribe.UserSubscribeFragment
import com.nbali.alinadi.shahabmousaviapp.utils.Utils
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment() : Fragment() {

    lateinit var profileViewModel:ProfileViewModel
    lateinit var questionViewModel: QuestionViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        questionViewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)
        var txtTitle = view.findViewById<TextView>(R.id.txt_home_title)
        var txtSubTitle = view.findViewById<TextView>(R.id.txt_home_subtitle)
        var frame = view.findViewById<ImageView>(R.id.home_bg_frame)
        var rlAnalaysis = view.findViewById<RelativeLayout>(R.id.home_analysis_parent_rl)
        var rlAdvices = view.findViewById<RelativeLayout>(R.id.home_advice_parent_rl)
        var rlSubscribe = view.findViewById<RelativeLayout>(R.id.home_subscribe_parent_rl)

        profileViewModel.firstPage().observe(this, Observer {
            txtTitle.text = it.title
            txtTitle.setTextColor(Color.parseColor(it.title_color))
            txtSubTitle.text = it.subtitle
            txtSubTitle.setTextColor(Color.parseColor(it.subtitle_color))
            Picasso.get().load(it.image).placeholder(R.drawable.load_img).into(frame)
        })

        if(profileViewModel.getToken() == ""){
            var trasaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
            trasaction.replace(R.id.main_fragment_frame,LoginFragment("home"))
            trasaction.addToBackStack(null)
            trasaction.commit()
        }else{
            rlAnalaysis.setOnClickListener{
                var trasaction = activity!!.supportFragmentManager.beginTransaction()
                Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                trasaction.replace(R.id.main_fragment_frame,AnalysisFragment())
                trasaction.addToBackStack(null)
                trasaction.commit()
            }

            rlAdvices.setOnClickListener{
                questionViewModel.getRole().observe(this, Observer {
                    if(it.role == "admin"){
                        var trasaction = activity!!.supportFragmentManager.beginTransaction()
                        Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                        trasaction.replace(R.id.main_fragment_frame,AdviceAdminFragment())
                        trasaction.addToBackStack(null)
                        trasaction.commit()
                    }else{
                        var trasaction = activity!!.supportFragmentManager.beginTransaction()
                        Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                        trasaction.replace(R.id.main_fragment_frame,AdviceFragment())
                        trasaction.addToBackStack(null)
                        trasaction.commit()
                    }
                })
            }

            rlSubscribe.setOnClickListener{
                var trasaction = activity!!.supportFragmentManager.beginTransaction()
                Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                trasaction.replace(R.id.main_fragment_frame,UserSubscribeFragment())
                trasaction.addToBackStack(null)
                trasaction.commit()
            }
        }

        return view
    }

}
