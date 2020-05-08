package com.nbali.alinadi.shahabmousaviapp.subscribe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

import com.nbali.alinadi.shahabmousaviapp.R

/**
 * A simple [Fragment] subclass.
 */
class PayFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_pay, container, false)
        var webView = view.findViewById<WebView>(R.id.pay_webView)
        var bundle = arguments
//        var subscribeId = bundle!!.getString("id")
//        var subscribeTitle = bundle!!.getString("title")
//        var subscribeAmount = bundle!!.getString("amount")
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        return view
    }

}
