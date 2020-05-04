package com.nbali.alinadi.shahabmousaviapp.analysis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nbali.alinadi.shahabmousaviapp.R

/**
 * A simple [Fragment] subclass.
 */
class AnalysisFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_analysis, container, false)
        return view
    }

}
