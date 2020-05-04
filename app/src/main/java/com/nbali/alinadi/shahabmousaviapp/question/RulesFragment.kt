package com.nbali.alinadi.shahabmousaviapp.question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Rule
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class RulesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_rules, container, false)
        var viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_rules_rules)
        recycler.layoutManager = LinearLayoutManager(context)
        viewModel.getAllRules().observe(this, Observer<List<Rule>> {
            recycler.adapter = RulesAdapter(context!!,it)
        })

        var btnBack = view.findViewById<ImageView>(R.id.rule_action_bar_arrow_back)
        btnBack.setOnClickListener{
            Utils.customAnimation(view,animation = Techniques.SlideOutRight)
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }
        return view
    }

}
