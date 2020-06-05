package com.nbali.alinadi.shahabmousaviapp.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Timing(
    @SerializedName("timing_id")
    val timing_id:String,
    @SerializedName("timing_user")
    val timing_user:String,
    @SerializedName("timing_day")
    val timing_day:String,
    @SerializedName("timing_time")
    val timing_time:String,
    @SerializedName("timing_date")
    val timing_date:String
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
        parcel.writeString(timing_id)
        parcel.writeString(timing_user)
        parcel.writeString(timing_day)
        parcel.writeString(timing_time)
        parcel.writeString(timing_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Timing> {
        override fun createFromParcel(parcel: Parcel): Timing {
            return Timing(parcel)
        }

        override fun newArray(size: Int): Array<Timing?> {
            return arrayOfNulls(size)
        }
    }
}