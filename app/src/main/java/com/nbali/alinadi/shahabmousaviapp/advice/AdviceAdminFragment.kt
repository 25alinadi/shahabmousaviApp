package com.nbali.alinadi.shahabmousaviapp.advice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.profile.ProfileViewModel

/**
 * A simple [Fragment] subclass.
 */
class AdviceAdminFragment : Fragment() {

    lateinit var viewModel: AdviceViewModel
    lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_advice_admin, container, false)
        viewModel = ViewModelProvider(this).get(AdviceViewModel::class.java)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_adviceAdmin_list)
        recycler.layoutManager = LinearLayoutManager(context)
        var emptyState = view.findViewById<LinearLayout>(R.id.ll_adviceAdmin_emptyState)
        var loadinAdvices = view.findViewById<FrameLayout>(R.id.frame_adviceAdmin_loadingadvice)

        viewModel.getAllAdviceTimingAdmin(profileViewModel.getRole()).observe(this, Observer {
            if(it.isNotEmpty()){
                recycler.adapter = AdviceAdminAdapter(context!!,it) { id,status ->
                    viewModel.changeRequestAdvice(id,status).observe(this, Observer {
                        Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                    })
                }
                loadinAdvices.visibility = View.GONE
            }else{
                loadinAdvices.visibility = View.GONE
                emptyState.visibility = View.VISIBLE
                recycler.visibility = View.GONE
            }
        })

        var btnBack = view.findViewById<ImageView>(R.id.adviceAdmin_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }
        return view
    }

}
