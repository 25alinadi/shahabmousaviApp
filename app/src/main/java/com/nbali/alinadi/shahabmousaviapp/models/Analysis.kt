package com.nbali.alinadi.shahabmousaviapp.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Analysis (
    @SerializedName("analysis_id")
    val analysis_id:String,
    @SerializedName("analysis_description")
    val analysis_description:String,
    @SerializedName("analysis_status")
    val analysis_status:String,
    @SerializedName("analysis_updated_at")
    val analysis_updated_at:String,
    @SerializedName("analysis_created_at")
    val analysis_created_at:String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(analysis_id)
        parcel.writeString(analysis_description)
        parcel.writeString(analysis_status)
        parcel.writeString(analysis_updated_at)
        parcel.writeString(analysis_created_at)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Analysis> {
        override fun createFromParcel(parcel: Parcel): Analysis {
            return Analysis(parcel)
        }

        override fun newArray(size: Int): Array<Analysis?> {
            return arrayOfNulls(size)
        }
    }
}