package com.nbali.alinadi.shahabmousaviapp.advice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar
import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Timing
import com.nbali.alinadi.shahabmousaviapp.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class AdviceFragment : Fragment(),DatePickerDialog.OnDateSetListener{
    lateinit var viewModel : AdviceViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_advice, container, false)
        viewModel = ViewModelProvider(this).get(AdviceViewModel::class.java)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_advice_list)
        recycler.layoutManager = LinearLayoutManager(context)
        var emptyState = view.findViewById<LinearLayout>(R.id.ll_advice_emptyState)
        var imgInsert = view.findViewById<ImageView>(R.id.img_advice_add_advice)
        var loadinAnalysis = view.findViewById<FrameLayout>(R.id.frame_advice_loadingadvice)

        viewModel.getAllAdvices().observe(this, Observer {
            if (it.isNotEmpty()){
                recycler.adapter = AdviceAdapter(context!!,it)
                loadinAnalysis.visibility = View.GONE
            }else{
                loadinAnalysis.visibility = View.GONE
                emptyState.visibility = View.VISIBLE
                recycler.visibility = View.GONE
            }
        })

        imgInsert.setOnClickListener{
            var persianCalendar = PersianCalendar()
            var datePickerDialog = DatePickerDialog.newInstance(
                    this@AdviceFragment,
                    persianCalendar.persianYear,
                    persianCalendar.persianMonth,
                    persianCalendar.persianDay
                )
            datePickerDialog.show(activity!!.fragmentManager, "Datepickerdialog")
        }

        var btnBack = view.findViewById<ImageView>(R.id.advice_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        var requestDate = year.toString()+"-"+(monthOfYear+1).toString()+"-"+dayOfMonth.toString()
        viewModel.getTiming(requestDate).observe(this, Observer {
            if (it.status == "failed"){
                Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
            }else{
                var dataList = arrayListOf<Timing>()
                dataList = it.data as ArrayList<Timing>
                var transaction = activity!!.supportFragmentManager.beginTransaction()
                Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.Landing)
                var requestAdvice = AdviceRequestFragment()
                var bundle = Bundle()
                bundle.putParcelableArrayList("requestDate",dataList)
                bundle.putString("message",it.message)
                requestAdvice.arguments = bundle
                transaction.replace(R.id.main_fragment_frame,requestAdvice)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        })
    }

}
