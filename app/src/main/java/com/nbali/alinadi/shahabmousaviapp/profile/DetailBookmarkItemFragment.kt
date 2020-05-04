package com.nbali.alinadi.shahabmousaviapp.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nbali.alinadi.shahabmousaviapp.R

/**
 * A simple [Fragment] subclass.
 */
class DetailBookmarkItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_detail_bookmark_item, container, false)
        return view
    }

}
