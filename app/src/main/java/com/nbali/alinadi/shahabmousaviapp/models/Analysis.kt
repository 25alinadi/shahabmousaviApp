package com.nbali.alinadi.shahabmousaviapp.models

import android.os.Parcel
import android.os.Parcelable

class Analysis (
    var analysis_id:String,
    var analysis_description:String,
    var analysis_status:String,
    var analysis_updated_at:String,
    var analysis_created_at:String
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