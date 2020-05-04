package com.nbali.alinadi.shahabmousaviapp.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.ProfileAccount

/**
 * A simple [Fragment] subclass.
 */
class ContactusFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_contactus, container, false)
        var cardInsta = view.findViewById<CardView>(R.id.rl_contactus_insta)
        var cardTelegram = view.findViewById<CardView>(R.id.rl_contactus_telegram)
        var cardSite = view.findViewById<CardView>(R.id.rl_contactus_website)


        return view
    }

}
