package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class Rule(
    @SerializedName("rule_id")
    val rule_id:String,
    @SerializedName("rule_text")
    val rule_text:String
)