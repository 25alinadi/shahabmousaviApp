package com.nbali.alinadi.shahabmousaviapp.post

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Product
import com.nbali.alinadi.shahabmousaviapp.room.RProduct
import com.nbali.alinadi.shahabmousaviapp.room.RoomViewModel
import com.nbali.alinadi.shahabmousaviapp.utils.Utils
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class DetailProductFragment() : Fragment() {

    lateinit var viewModel:RoomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_detail_product, container, false)
        var bundle = arguments
        var detailProduct = bundle!!.getParcelable<Product>("product")
        viewModel = ViewModelProvider(this).get(RoomViewModel::class.java)
        var imageProduct = view.findViewById<ImageView>(R.id.img_detialproduct_image)
        var txtTitle = view.findViewById<TextView>(R.id.txt_detialproduct_title)
        var txtAmount = view.findViewById<TextView>(R.id.txt_detailproduct_amount)
        var txtContent = view.findViewById<TextView>(R.id.txt_detailproduct_content)
        var btnLink = view.findViewById<ImageView>(R.id.iv_detailproducts_website_link)
        var btnBookmark = view.findViewById<ImageView>(R.id.iv_detailproducts_bookmark)
        var btnShare = view.findViewById<ImageView>(R.id.iv_detailproducts_share)

        viewModel.getSignedProduct(detailProduct!!.product_name).observe(this, Observer {
            if(it != null){
                btnBookmark.setColorFilter(
                    ContextCompat.getColor(context!!,
                    R.color.gray400
                ), android.graphics.PorterDuff.Mode.SRC_IN)
                btnBookmark.tag="signed"
            }
        })

        Picasso.get().load(detailProduct.product_image).placeholder(R.drawable.load_img).into(imageProduct)
        txtTitle.text = detailProduct.product_name
        txtAmount.text = detailProduct.product_amount_app

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtContent.text = Html.fromHtml(detailProduct.product_description, Html.FROM_HTML_MODE_COMPACT);
        } else {
            txtContent.text = Html.fromHtml(detailProduct.product_description);
        }

        btnLink.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse(detailProduct.product_link))
            startActivity(intent)
        }

        btnBookmark.setOnClickListener{
            if (btnBookmark.tag == "signed"){
                btnBookmark.setColorFilter(
                    ContextCompat.getColor(context!!,
                        R.color.prussian_blue
                    ), android.graphics.PorterDuff.Mode.SRC_IN)
                btnBookmark.tag = "unsigned"
                var rProduct = RProduct(detailProduct.product_id.toInt(),detailProduct.product_name,detailProduct.product_description,detailProduct.product_image,detailProduct.product_link,detailProduct.product_amount_app,detailProduct.product_amount)
                viewModel.deleteProduct(rProduct)
                Toast.makeText(context,"محصول از نشان شده ها حذف شد",Toast.LENGTH_SHORT).show()

            }else{
                var rProduct = RProduct(detailProduct.product_id.toInt(),detailProduct.product_name,detailProduct.product_description,detailProduct.product_image,detailProduct.product_link,detailProduct.product_amount_app,detailProduct.product_amount)
                viewModel.insert(rProduct)
                Toast.makeText(context,"محصول در نشان شده ها قرار گرفت",Toast.LENGTH_SHORT).show()
            }
        }


        btnShare.setOnClickListener{
            var intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,detailProduct.product_name+"\n \n"+detailProduct.product_link)
            startActivity(Intent.createChooser(intent, "انتشار "+detailProduct.product_name))
            startActivity(intent)
        }

        var btnBack = view.findViewById<ImageView>(R.id.productdetail_action_bar_arrow_back)
        btnBack.setOnClickListener{
            Utils.customAnimation(view,animation = Techniques.SlideOutDown)
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }
}
