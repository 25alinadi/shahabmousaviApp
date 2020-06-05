package com.nbali.alinadi.shahabmousaviapp.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Product (
    @SerializedName("product_id")
    val product_id:String,
    @SerializedName("product_name")
    val product_name:String,
    @SerializedName("product_image")
    val product_image:String,
    @SerializedName("product_description")
    val product_description:String,
    @SerializedName("product_link")
    val product_link:String,
    @SerializedName("product_amount")
    val product_amount:String,
    @SerializedName("product_amount_app")
    val product_amount_app:String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(product_id)
        parcel.writeString(product_name)
        parcel.writeString(product_image)
        parcel.writeString(product_description)
        parcel.writeString(product_link)
        parcel.writeString(product_amount)
        parcel.writeString(product_amount_app)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}