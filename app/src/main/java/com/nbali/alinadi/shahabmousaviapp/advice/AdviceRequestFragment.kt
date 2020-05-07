package com.nbali.alinadi.shahabmousaviapp.advice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Timing

/**
 * A simple [Fragment] subclass.
 */
class AdviceRequestFragment : Fragment() {
    lateinit var viewModel: AdviceViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_advice_request, container, false)
        viewModel = ViewModelProvider(this).get(AdviceViewModel::class.java)
        var bundle = arguments
        var timing = bundle!!.getParcelableArrayList<Timing>("requestDate")
        var message = bundle!!.getString("message")
        var emptyState = view.findViewById<LinearLayout>(R.id.ll_advicerequest_emptyState)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_advicerequest_list)
        recycler.layoutManager = LinearLayoutManager(context)
        var loadinAnalysisRow = view.findViewById<FrameLayout>(R.id.frame_advicerequest_loadingadvicerequest)

        if (timing.size > 0){
            recycler.adapter = AdviceRequestAdapter(context!!,timing) {
                viewModel.insertTiming(it).observe(this, Observer {
                    if(it.status == "success"){
                        Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                        var transaction = activity!!.supportFragmentManager.popBackStack()
                    }else{
                        Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                    }
                })
            }
            loadinAnalysisRow.visibility = View.GONE
        }else{
            loadinAnalysisRow.visibility = View.GONE
            emptyState.visibility = View.VISIBLE
            recycler.visibility = View.GONE
        }

        var btnBack = view.findViewById<ImageView>(R.id.advicerequest_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
