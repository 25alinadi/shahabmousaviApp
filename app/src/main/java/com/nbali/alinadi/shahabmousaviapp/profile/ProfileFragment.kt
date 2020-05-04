package com.nbali.alinadi.shahabmousaviapp.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.daimajia.androidanimations.library.Techniques
import com.google.android.material.tabs.TabLayout

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {
    lateinit var viewModel: ProfileViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_profile, container, false)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var tabLayout = view.findViewById<TabLayout>(R.id.tab_profile)
        var viewPager = view.findViewById<ViewPager>(R.id.viewPager_profile)
        var adapter = ProfileViewPagerAdapter(childFragmentManager)
        var parentProfileName = view.findViewById<RelativeLayout>(R.id.rel_profile_profileNameFrame)
        var profileName = view.findViewById<TextView>(R.id.txt_profile_name)

        if(viewModel.getToken() == ""){
            parentProfileName.visibility = View.GONE
        }else{
            profileName.text = viewModel.getFullName()
        }

        tabLayout.setupWithViewPager(viewPager)
        adapter.addFragments(ContactusFragment(),"ارتباط با ما")
        adapter.addFragments(AccountFragment(),"حساب کاربری")
        viewPager.adapter = adapter

        viewPager.setCurrentItem(1)
        return view
    }

}
