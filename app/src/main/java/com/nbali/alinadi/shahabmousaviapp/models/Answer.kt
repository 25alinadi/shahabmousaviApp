package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class Answer(
    @SerializedName("question_id")
    val question_id:String,
    @SerializedName("question_user_id")
    val question_user_id:String,
    @SerializedName("question_product")
    val question_product:String,
    @SerializedName("question_title")
    val question_title:String,
    @SerializedName("question_text")
    val question_text:String,
    @SerializedName("question_answer")
    val question_answer:String,
    @SerializedName("question_type")
    val question_type:String,
    @SerializedName("question_status")
    val question_status:String,
    @SerializedName("question_updated_app")
    val question_updated_app:String,
    @SerializedName("question_created_app")
    val question_created_app:String,
    @SerializedName("display_name")
    val display_name:String
)