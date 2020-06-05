package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class Message (
    @SerializedName("status")
    val status:String,
    @SerializedName("message")
    val message:String,
    @SerializedName("token")
    val token:String,
    @SerializedName("fullName")
    val fullName:String,
    @SerializedName("role")
    val role:String,
    @SerializedName("data")
    val data:List<Timing>
)