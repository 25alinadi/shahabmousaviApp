package com.nbali.alinadi.shahabmousaviapp.advice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nbali.alinadi.shahabmousaviapp.R

/**
 * A simple [Fragment] subclass.
 */
class AdviceFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_advice, container, false)
        return view
    }

}
