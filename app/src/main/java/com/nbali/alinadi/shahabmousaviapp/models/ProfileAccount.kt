package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class ProfileAccount(
    @SerializedName("title")
    val title:String,
    @SerializedName("icon")
    val icon:Int
)