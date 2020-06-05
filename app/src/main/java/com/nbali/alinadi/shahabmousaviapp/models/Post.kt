package com.nbali.alinadi.shahabmousaviapp.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Post(
    @SerializedName("post_id")
    val post_id : String,
    @SerializedName("post_title")
    val post_title : String,
    @SerializedName("post_content")
    val post_content : String,
    @SerializedName("post_link")
    val post_link : String,
    @SerializedName("post_image")
    val post_image : String,
    @SerializedName("post_date")
    val post_date : String
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