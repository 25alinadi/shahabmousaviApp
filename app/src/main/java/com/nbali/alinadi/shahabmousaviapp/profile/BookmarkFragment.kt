package com.nbali.alinadi.shahabmousaviapp.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Product
import com.nbali.alinadi.shahabmousaviapp.post.DetailProductFragment
import com.nbali.alinadi.shahabmousaviapp.room.RoomViewModel

/**
 * A simple [Fragment] subclass.
 */
class BookmarkFragment : Fragment() {

    lateinit var viewModel: RoomViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_bookmark, container, false)
        viewModel = ViewModelProvider(this).get(RoomViewModel::class.java)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_bookmark_list)
        var txtWarning=view.findViewById<TextView>(R.id.txt_bookmark_emptyList)
        recycler.layoutManager = LinearLayoutManager(context)
        viewModel.getAllProduct().observe(this, Observer {
            if(it.isNotEmpty()){
                recycler.adapter = BookmarkAdapter(context!!,it) {
                    var transaction = activity!!.supportFragmentManager.beginTransaction()
                    var detailRProduct = DetailProductFragment()
                    var bundle = Bundle()
                    var product = Product(it.id.toString(),it.name,it.image,it.content,it.link,it.amount,it.amount_app)
                    bundle.putParcelable("product",product)
                    detailRProduct.arguments = bundle
                    transaction.replace(R.id.main_fragment_frame,detailRProduct)
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }else{
                txtWarning.visibility = View.VISIBLE
                recycler.visibility = View.GONE
            }

        })

        var btnBack = view.findViewById<ImageView>(R.id.bookmark_action_bar_arrow_back)
        btnBack.setOnClickListener{
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
