package com.nbali.alinadi.shahabmousaviapp.question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Product
import com.nbali.alinadi.shahabmousaviapp.post.PostViewModel
import com.nbali.alinadi.shahabmousaviapp.utils.Utils
import org.angmarch.views.NiceSpinner

/**
 * A simple [Fragment] subclass.
 */
class AskFragment : Fragment() {

    lateinit var productViewModel : PostViewModel
    lateinit var viewModel : QuestionViewModel
    var productName: MutableList<String> = arrayListOf()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_ask, container, false)
        viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)
        productViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        var edtTitle = view.findViewById<EditText>(R.id.edt_ask_title)
        var edtText = view.findViewById<EditText>(R.id.edt_ask_text)
        var spinner = view.findViewById<NiceSpinner>(R.id.nice_ask_spinner)
        var btnSend = view.findViewById<Button>(R.id.btn_ask_ask)
        var radioGroup=view.findViewById<RadioGroup>(R.id.rg_ask_radioGroup)
        var btnBuy=view.findViewById<Button>(R.id.btn_ask_buy)
        var txtCoin=view.findViewById<TextView>(R.id.txt_ask_coinText)
        var txtShowRules=view.findViewById<TextView>(R.id.txt_ask_showRules)
        var txtBuy=view.findViewById<TextView>(R.id.txt_ask_rule)
        var specialRadioButton=view.findViewById<RadioButton>(R.id.radio_ask_special)

        productViewModel.getAllProductsTitle().observe(this, Observer<List<Product>> {
            productName.add("محصول مورد نظر را انتخاب کنید ...")
            for (i in 0 until it.size) {
                productName.add(it[i].product_name!!)
            }
            spinner.attachDataSource(productName)
        })

        btnSend.setOnClickListener{
            var type=0
            var selectedId=radioGroup.checkedRadioButtonId
            var radioButton=view.findViewById<RadioButton>(selectedId)
            var textType=radioButton.text
            if(!textType.contains("مشاوره")) {
                type = 1
            }

            var spinnerText =  ""
            if(!spinner.selectedItem.equals("محصول مورد نظر را انتخاب کنید ...")){
                spinnerText = spinner.selectedItem.toString()
            }else{
                spinnerText =  ""
            }

            viewModel.ask(edtTitle.text.toString(),edtText.text.toString(),spinnerText,type).observe(this,
                Observer{
                    if(it.status == "success"){
                        Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                        var transaction = activity!!.supportFragmentManager.popBackStack()
                    }else{
                        Toast.makeText(context,it.message,Toast.LENGTH_SHORT).show()
                    }
                })
        }

        specialRadioButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Utils.customAnimation(txtBuy,duration = 500,animation = Techniques.FadeInDown)
                Utils.customAnimation(btnBuy,duration = 500,animation = Techniques.FadeInDown)
                txtBuy.visibility=View.VISIBLE
                btnBuy.visibility=View.VISIBLE
            }else{
                Utils.customAnimation(txtBuy,duration = 500,animation = Techniques.FadeOutUp)
                Utils.customAnimation(btnBuy,duration = 500,animation = Techniques.FadeOutUp)
            }
        }

        txtShowRules.setOnClickListener{
            var transaction=activity!!.supportFragmentManager.beginTransaction()
            Utils.customAnimation(activity!!.findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
            transaction.add(R.id.main_fragment_frame,RulesFragment(),"rulesFragment")
            transaction.addToBackStack(null)
            transaction.commit()
        }

        btnBuy.setOnClickListener{

        }

        var btnBack = view.findViewById<ImageView>(R.id.ask_action_bar_arrow_back)
        btnBack.setOnClickListener{
            Utils.customAnimation(view,animation = Techniques.SlideOutDown)
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
