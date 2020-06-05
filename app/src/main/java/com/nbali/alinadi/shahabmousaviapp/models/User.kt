package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class User (
    @SerializedName("id")
    val id:String,
    @SerializedName("firstName")
    val firstName:String,
    @SerializedName("lastName")
    val lastName:String,
    @SerializedName("email")
    val email:String,
    @SerializedName("pass")
    val pass:String,
    @SerializedName("phone")
    val phone:String,
    @SerializedName("gender")
    val gender:Int
)