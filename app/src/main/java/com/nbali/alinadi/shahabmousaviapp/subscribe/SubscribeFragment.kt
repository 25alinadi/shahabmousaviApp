package com.nbali.alinadi.shahabmousaviapp.subscribe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Subscribe
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class SubscribeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_subscribe, container, false)
        var viewModel = ViewModelProvider(this).get(SubscribeViewModel::class.java)
        var recyclerView = view.findViewById<RecyclerView>(R.id.subscribe_recycler_rv)
        recyclerView.layoutManager = GridLayoutManager(context,2,LinearLayoutManager.VERTICAL,false)
        viewModel.getAllSubscribes().observe(this, Observer {
            recyclerView.adapter = SubscribeAdapter(context!!,it) {
                var dialog = SubscribeDialog()
                dialog.show(childFragmentManager,null)
            }
        })

        var btnBack = view.findViewById<ImageView>(R.id.action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
