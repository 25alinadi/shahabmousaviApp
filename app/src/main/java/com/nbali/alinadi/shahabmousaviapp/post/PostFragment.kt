package com.nbali.alinadi.shahabmousaviapp.post

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Post
import com.nbali.alinadi.shahabmousaviapp.models.Product
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

/**
 * A simple [Fragment] subclass.
 */
class PostFragment : Fragment() {
    lateinit var viewModel:PostViewModel
    val VIEW_POST = 0
    val VIEW_PRODUCT = 1
    var last_view = VIEW_POST
    var postList: List<Post> = listOf<Post>()
    var productList: List<Product> = listOf<Product>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_post, container, false)
        viewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        var recycler = view.findViewById<RecyclerView>(R.id.rv_post_postList)
        var txtPost = view.findViewById<TextView>(R.id.txt_post_post)
        var txtProduct = view.findViewById<TextView>(R.id.txt_post_product)
        var txtPostEmpty = view.findViewById<TextView>(R.id.txt_post_empty)
        var txtProductEmpty = view.findViewById<TextView>(R.id.txt_product_empty)
        var loadingFrame = view.findViewById<FrameLayout>(R.id.frame_posts_loadingposts)


        recycler.layoutManager = LinearLayoutManager(context)

        viewModel.getAllPosts().observe(this, Observer { it ->
            postList = it
            if(it.isNotEmpty()){
                Utils.customAnimation(recycler,animation = Techniques.SlideInRight)
                recycler.adapter = PostAdapter(context!!,it) {
                    var transaction = activity!!.supportFragmentManager.beginTransaction()
                    var detailPost = DetailPostFragment()
                    var selectedpost: Post? = null
                    for (i in 0 until postList.size){
                        var id = postList[i].post_id
                        if(id == it){
                            selectedpost = postList[i]
                        }
                    }
                    var bundle = Bundle()
                    bundle.putParcelable("post", selectedpost)
                    detailPost.arguments = bundle
                    transaction.replace(R.id.main_fragment_frame,detailPost)
                    transaction.addToBackStack(null)
                    transaction.commit()
                    loadingFrame.visibility = View.GONE
                }
            }else{
                txtPostEmpty.visibility = View.VISIBLE

                recycler.visibility = View.GONE
            }
            loadingFrame.visibility = View.GONE
            last_view = VIEW_POST
        })

        txtPost.setOnClickListener{
            if(last_view != VIEW_POST){
                loadingFrame.visibility = View.VISIBLE
                txtProduct.setTextColor(ContextCompat.getColor(context!!,R.color.prussian_blue))
                txtProduct.setBackgroundColor(ContextCompat.getColor(context!!,R.color.white))
                txtPost.setTextColor(ContextCompat.getColor(context!!,R.color.white))
                txtPost.setBackgroundColor(ContextCompat.getColor(context!!,R.color.prussian_blue))
                viewModel.getAllPosts().observe(this, Observer {
                    postList = it
                    if(it.isNotEmpty()){
                        Utils.customAnimation(recycler,animation = Techniques.SlideInRight)
                        recycler.adapter = PostAdapter(context!!,it) {
                            var transaction = activity!!.supportFragmentManager.beginTransaction()
                            var detailPost = DetailPostFragment()
                            var selectedpost: Post? = null
                            for (i in 0 until postList.size){
                                var id = postList[i].post_id
                                if(id == it){
                                    selectedpost = postList[i]
                                }
                            }
                            var bundle = Bundle()
                            bundle.putParcelable("post", selectedpost)
                            detailPost.arguments = bundle
                            transaction.replace(R.id.main_fragment_frame,detailPost)
                            transaction.addToBackStack(null)
                            transaction.commit()

                        }
                    }else{
                        txtPostEmpty.visibility = View.VISIBLE
                        txtProductEmpty.visibility = View.GONE
                        recycler.visibility = View.GONE
                    }

                    loadingFrame.visibility = View.GONE
                })

                last_view = VIEW_POST
            }
        }

        txtProduct.setOnClickListener{
            if(last_view != VIEW_PRODUCT){
                loadingFrame.visibility = View.VISIBLE
                txtPost.setTextColor(ContextCompat.getColor(context!!,R.color.prussian_blue))
                txtPost.setBackgroundColor(ContextCompat.getColor(context!!,R.color.white))
                txtProduct.setTextColor(ContextCompat.getColor(context!!,R.color.white))
                txtProduct.setBackgroundColor(ContextCompat.getColor(context!!,R.color.prussian_blue))

                viewModel.getAllProducts().observe(this, Observer {
                    productList = it
                    if(it.isNotEmpty()){
                        Utils.customAnimation(recycler,animation = Techniques.SlideInLeft)
                        recycler.adapter = ProductAdapter(context!!,it) {
                            var transaction = activity!!.supportFragmentManager.beginTransaction()
                            var detailProduct = DetailProductFragment()
                            var bundle = Bundle()
                            bundle.putParcelable("product", it)
                            detailProduct.arguments = bundle
                            transaction.replace(R.id.main_fragment_frame,detailProduct)
                            transaction.addToBackStack(null)
                            transaction.commit()
                        }
                    }else{
                        txtPostEmpty.visibility = View.GONE
                        txtProductEmpty.visibility = View.VISIBLE
                        recycler.visibility = View.GONE
                    }

                    loadingFrame.visibility = View.GONE
                })

                last_view = VIEW_PRODUCT
            }
        }

        return view
    }

}
