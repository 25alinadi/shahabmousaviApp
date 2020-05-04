package com.nbali.alinadi.shahabmousaviapp.question

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class AnswerFragment : Fragment() {
    lateinit var viewModel:QuestionViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_answer, container, false)
        viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)
        var fab = view.findViewById<FloatingActionButton>(R.id.fab_answer)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_answer_list)
        var emptyState = view.findViewById<LinearLayout>(R.id.lin_answer_emptyFrame)
        var txtNewQuestion = view.findViewById<TextView>(R.id.txt_answer_askNewQuestion)

        recycler.layoutManager = LinearLayoutManager(context)
        viewModel.getAnswer().observe(this, Observer {
            if (!it.isEmpty()){
                fab.show()
                Utils.customAnimation(recycler,animation = Techniques.SlideInRight)
                recycler.adapter = AnswerAdapter(context!!,it)
            } else{
                fab.hide()
                emptyState.visibility = View.VISIBLE
            }
        })

        fab.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInUp)
            transaction.replace(R.id.main_fragment_frame,AskFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        txtNewQuestion.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInUp)
            transaction.replace(R.id.main_fragment_frame,AskFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        var btnBack = view.findViewById<ImageView>(R.id.answer_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
