package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class Info(
    @SerializedName("image")
    val image:String,
    @SerializedName("title")
    val title:String,
    @SerializedName("title_color")
    val title_color:String,
    @SerializedName("subtitle")
    val subtitle:String,
    @SerializedName("subtitle_color")
    val subtitle_color:String,
    @SerializedName("insta_link")
    val insta_link:String,
    @SerializedName("telegram_link")
    val telegram_link:String,
    @SerializedName("site_link")
    val site_link:String,
    @SerializedName("site_phone")
    val site_phone:String
)