package com.nbali.alinadi.shahabmousaviapp.analysis

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class AnalysisFragment : Fragment() {

    lateinit var viewModel: AnalysisViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_analysis, container, false)
        viewModel = ViewModelProvider(this).get(AnalysisViewModel::class.java)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_analysis_list)
        recycler.layoutManager = LinearLayoutManager(context)
        var emptyState = view.findViewById<LinearLayout>(R.id.ll_analysis_emptyState)
        var imgInsert = view.findViewById<ImageView>(R.id.img_analysis_add_basket)
        var loadinAnalysis = view.findViewById<FrameLayout>(R.id.frame_analysis_loadinganalysis)

        viewModel.getAllAnalysis().observe(this, Observer {
            if(it.isNotEmpty()){
                recycler.adapter = AnalysisAdapter(context!!,it) {
                    var transaction = activity!!.supportFragmentManager.beginTransaction()
                    Utils.customAnimation(recycler,animation = Techniques.Landing)
                    var detailAnalysis = DetailAnalysisFragment()
                    var bundle = Bundle()
                    bundle.putParcelable("analysis",it)
                    detailAnalysis.arguments = bundle
                    transaction.replace(R.id.main_fragment_frame,detailAnalysis)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
                loadinAnalysis.visibility = View.GONE
            }else{
                loadinAnalysis.visibility = View.GONE
                emptyState.visibility = View.VISIBLE
                recycler.visibility = View.GONE
            }
        })

        imgInsert.setOnClickListener{
            var dialog = AnalysisDialog()
            dialog.show(childFragmentManager,null)
        }

        var btnBack = view.findViewById<ImageView>(R.id.analysis_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
