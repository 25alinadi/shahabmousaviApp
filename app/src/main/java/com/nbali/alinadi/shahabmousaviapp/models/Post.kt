package com.nbali.alinadi.shahabmousaviapp.models

import android.os.Parcel
import android.os.Parcelable

class Post(
    var post_id : String,
    var post_title : String,
    var post_content : String,
    var post_link : String,
    var post_image : String,
    var post_date : String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(post_id)
        parcel.writeString(post_title)
        parcel.writeString(post_content)
        parcel.writeString(post_link)
        parcel.writeString(post_image)
        parcel.writeString(post_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Post> {
        override fun createFromParcel(parcel: Parcel): Post {
            return Post(parcel)
        }

        override fun newArray(size: Int): Array<Post?> {
            return arrayOfNulls(size)
        }
    }
}