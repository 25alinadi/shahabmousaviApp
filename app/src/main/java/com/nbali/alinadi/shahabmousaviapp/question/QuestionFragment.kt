package com.nbali.alinadi.shahabmousaviapp.question

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.profile.ProfileViewModel
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {

    lateinit var viewModel: QuestionViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_question, container, false)
        viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)
        var fab = view.findViewById<FloatingActionButton>(R.id.fab_question_newQuestion)
        var btnQuestions = view.findViewById<RelativeLayout>(R.id.rel_question_questionList)
        var btnRules = view.findViewById<RelativeLayout>(R.id.rl_question_rules)
        var checkBox = view.findViewById<CheckBox>(R.id.ch_quesetion_agree)
        var txtRules = view.findViewById<TextView>(R.id.txt_question_agreeWhitRules)

        viewModel.getRole().observe(this, Observer {
            if(it.role == "admin"){
                fab.hide()
                checkBox.visibility = View.GONE
                txtRules.visibility = View.GONE
            }
        })

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Utils.customAnimation(checkBox,animation = Techniques.FadeOut)
                Utils.customAnimation(txtRules,animation = Techniques.FadeOut)
                Utils.customAnimation(fab,animation = Techniques.SlideInRight)
                checkBox.visibility = View.GONE
                txtRules.visibility = View.GONE
                fab.show()
            }
            else{
                checkBox.visibility = View.VISIBLE
                txtRules.visibility = View.VISIBLE
                fab.hide()
            }
        }

        btnQuestions.setOnClickListener{
            viewModel.getRole().observe(this, Observer {
                if (it.role == "admin"){
                    var transaction = activity!!.supportFragmentManager.beginTransaction()
                    Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                    transaction.replace(R.id.main_fragment_frame,AdminAnswersFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }else{
                    var transaction = activity!!.supportFragmentManager.beginTransaction()
                    Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                    transaction.replace(R.id.main_fragment_frame,AnswerFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            })
        }

        btnRules.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.Landing)
            transaction.replace(R.id.main_fragment_frame,RulesFragment(),"rulesFragment")
            transaction.addToBackStack(null)
            transaction.commit()
        }

        fab.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInUp)
            transaction.replace(R.id.main_fragment_frame,AskFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

}
