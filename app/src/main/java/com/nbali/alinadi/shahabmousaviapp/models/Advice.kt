package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class Advice(
    @SerializedName("advice_day")
    val advice_day:String,
    @SerializedName("advice_date")
    val advice_date:String,
    @SerializedName("advice_time")
    val advice_time:String,
    @SerializedName("advice_status")
    val advice_status:String,
    @SerializedName("advice_create_date")
    val advice_create_date:String
)