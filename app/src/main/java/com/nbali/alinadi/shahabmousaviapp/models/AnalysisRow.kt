package com.nbali.alinadi.shahabmousaviapp.models

import com.google.gson.annotations.SerializedName

class AnalysisRow(
    @SerializedName("row_symbol")
    val row_symbol:String,
    @SerializedName("row_average_buy")
    val row_average_buy:String,
    @SerializedName("row_number_share")
    val row_number_share:String,
    @SerializedName("row_percent_share")
    val row_percent_share:String,
    @SerializedName("row_description")
    val row_description:String
)