package com.nbali.alinadi.shahabmousaviapp.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.ProfileAccount

/**
 * A simple [Fragment] subclass.
 */
class ContactusFragment : Fragment() {

    lateinit var profileViewModel: ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_contactus, container, false)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var cardInsta = view.findViewById<CardView>(R.id.rl_contactus_insta)
        var cardTelegram = view.findViewById<CardView>(R.id.rl_contactus_telegram)
        var cardSite = view.findViewById<CardView>(R.id.rl_contactus_website)
        var cardPhone = view.findViewById<CardView>(R.id.rl_contactus_phone)

        profileViewModel.contactUs().observe(this, Observer {
            var insta_link = it.insta_link
            var telegram_link = it.telegram_link
            var website_link = it.site_link
            var phone_link = Uri.parse("tel:" + it.site_phone)

            cardInsta.setOnClickListener{
                var intentInsta = Intent(Intent.ACTION_VIEW, Uri.parse("$insta_link"))
                startActivity(intentInsta)
            }

            cardTelegram.setOnClickListener{
                var intentTelegram = Intent(Intent.ACTION_VIEW, Uri.parse(telegram_link))
                startActivity(intentTelegram)
            }

            cardSite.setOnClickListener{
                var intentSite = Intent(Intent.ACTION_VIEW, Uri.parse(website_link))
                startActivity(intentSite)
            }

            cardPhone.setOnClickListener{
                var intentPhone = Intent(Intent.ACTION_DIAL, phone_link)
                startActivity(intentPhone)
            }
        })

        return view
    }

}
