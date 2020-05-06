package com.nbali.alinadi.shahabmousaviapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.advice.AdviceFragment
import com.nbali.alinadi.shahabmousaviapp.analysis.AnalysisFragment
import com.nbali.alinadi.shahabmousaviapp.profile.LoginFragment
import com.nbali.alinadi.shahabmousaviapp.profile.ProfileViewModel
import com.nbali.alinadi.shahabmousaviapp.subscribe.SubscribeFragment
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment() : Fragment() {

    lateinit var profileViewModel:ProfileViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var rlAnalaysis = view.findViewById<RelativeLayout>(R.id.home_analysis_parent_rl)
        var rlAdvices = view.findViewById<RelativeLayout>(R.id.home_advice_parent_rl)
        var rlSubscribe = view.findViewById<RelativeLayout>(R.id.home_subscribe_parent_rl)

        rlAnalaysis.setOnClickListener{
            if(profileViewModel.getToken() == ""){
                var trasaction = activity!!.supportFragmentManager.beginTransaction()
                Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                trasaction.replace(R.id.main_fragment_frame,LoginFragment("analysis"))
                trasaction.addToBackStack(null)
                trasaction.commit()
            }else{
                var trasaction = activity!!.supportFragmentManager.beginTransaction()
                Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                trasaction.replace(R.id.main_fragment_frame,AnalysisFragment())
                trasaction.addToBackStack(null)
                trasaction.commit()
            }
        }

        rlAdvices.setOnClickListener{
            var trasaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
            trasaction.replace(R.id.main_fragment_frame,AdviceFragment())
            trasaction.addToBackStack(null)
            trasaction.commit()
        }

        rlSubscribe.setOnClickListener{
            var trasaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
            trasaction.replace(R.id.main_fragment_frame,SubscribeFragment())
            trasaction.addToBackStack(null)
            trasaction.commit()
//            onBottomNavigationItemChange(4)
        }

        return view
    }

}
