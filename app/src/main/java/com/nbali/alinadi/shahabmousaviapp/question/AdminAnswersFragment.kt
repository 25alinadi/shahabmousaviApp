package com.nbali.alinadi.shahabmousaviapp.question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.profile.ProfileViewModel

/**
 * A simple [Fragment] subclass.
 */
class AdminAnswersFragment : Fragment() {

    lateinit var questionViewModel: QuestionViewModel
    lateinit var profileViewModel: ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_admin_answers, container, false)
        questionViewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_noanswer_list)
        recycler.layoutManager = LinearLayoutManager(context)
        var emptyState = view.findViewById<LinearLayout>(R.id.lin_noanswer_emptyFrame)

        questionViewModel.getAllNoAnswers(profileViewModel.getRole()).observe(this, Observer {
            if (it.isNotEmpty()){
                recycler.adapter = AdminAnswersAdapter(context!!,it) {
                    questionViewModel.returnedAnswer(it.question_id).observe(this, Observer {
                        Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                    })
                }
            }else{
                emptyState.visibility = View.VISIBLE
                recycler.visibility = View.GONE
            }
        })

        return view
    }

}
