package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class UserSubscribe(
    @SerializedName("subscribe_title")
    val subscribe_title:String,
    @SerializedName("subscribe_duration")
    val subscribe_duration:String,
    @SerializedName("subscribe_question")
    val subscribe_question:String,
    @SerializedName("subscribe_expired_at")
    val subscribe_expired_at:String,
    @SerializedName("subscribe_created_at")
    val subscribe_created_at:String,
    @SerializedName("subscribe_status")
    val subscribe_status:String
)