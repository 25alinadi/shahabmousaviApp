package com.nbali.alinadi.shahabmousaviapp.analysis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Analysis

/**
 * A simple [Fragment] subclass.
 */
class DetailAnalysisFragment : Fragment() {

    lateinit var viewModel : AnalysisViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_detail_analysis, container, false)
        viewModel = ViewModelProvider(this).get(AnalysisViewModel::class.java)
        var bundle = arguments
        var detailAnalysis = bundle!!.getParcelable<Analysis>("analysis")
        var emptyState = view.findViewById<RelativeLayout>(R.id.rl_analysisRow_emptyState)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_analysisRow_rows)
        recycler.layoutManager = LinearLayoutManager(context)
        var loadinAnalysisRow = view.findViewById<FrameLayout>(R.id.frame_analysisRow_loadinganalysisrow)

        viewModel.getAllRows(detailAnalysis.analysis_id).observe(this, Observer {
            if(it.isNotEmpty()){
                recycler.adapter = AnalysisRowAdapter(context!!,it)
                loadinAnalysisRow.visibility = View.GONE
            }else{
                loadinAnalysisRow.visibility = View.GONE
                emptyState.visibility = View.VISIBLE
                recycler.visibility = View.GONE
            }
        })

        var btnBack = view.findViewById<ImageView>(R.id.analysisRow_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
