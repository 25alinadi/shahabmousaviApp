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
import com.daimajia.androidanimations.library.Techniques

import com.nbali.alinadi.shahabmousaviapp.R
import com.nbali.alinadi.shahabmousaviapp.models.Post
import com.nbali.alinadi.shahabmousaviapp.utils.Utils
import com.squareup.picasso.Picasso

/**
 * A simple [Fragment] subclass.
 */
class DetailPostFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_detail_post, container, false)
        var bundle = arguments
        var detailPost = bundle!!.getParcelable<Post>("post")
        var imagePost = view.findViewById<ImageView>(R.id.img_detialpost_image)
        var txtTitle = view.findViewById<TextView>(R.id.txt_detialpost_title)
        var txtDate = view.findViewById<TextView>(R.id.txt_detailpost_date)
        var txtContent = view.findViewById<TextView>(R.id.txt_detailpost_content)
        var btnLink = view.findViewById<ImageView>(R.id.iv_detailposts_website_link)
        var btnShare = view.findViewById<ImageView>(R.id.iv_detailposts_share)

        Picasso.get().load(detailPost.post_image).placeholder(R.drawable.load_img).into(imagePost)
        txtTitle.text = detailPost.post_title
        txtDate.text = "تاریخ : " + detailPost.post_date

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            txtContent.text = Html.fromHtml(detailPost.post_content, Html.FROM_HTML_MODE_COMPACT);
        } else {
            txtContent.text = Html.fromHtml(detailPost.post_content);
        }

        btnLink.setOnClickListener {
            var intent= Intent(Intent.ACTION_VIEW, Uri.parse(detailPost.post_link))
            startActivity(intent)
        }

        btnShare.setOnClickListener{
            var intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,detailPost.post_title+"\n \n"+detailPost.post_link)
            startActivity(Intent.createChooser(intent,"انتشار پست "+detailPost.post_title))
            startActivity(intent)
        }

        var btnBack = view.findViewById<ImageView>(R.id.postdetail_action_bar_arrow_back)
        btnBack.setOnClickListener{
            Utils.customAnimation(view,animation = Techniques.SlideOutDown)
            var transaction = activity!!.supportFragmentManager.popBackStack()
        }

        return view
    }

}
