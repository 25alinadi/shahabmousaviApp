package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class Subscribe(
    @SerializedName("subscribe_id")
    val subscribe_id:String,
    @SerializedName("subscribe_title")
    val subscribe_title:String,
    @SerializedName("subscribe_duration")
    val subscribe_duration:String,
    @SerializedName("subscribe_question")
    val subscribe_question:String,
    @SerializedName("subscribe_amount")
    val subscribe_amount:String,
    @SerializedName("subscribe_amount_app")
    val subscribe_amount_app:String
)