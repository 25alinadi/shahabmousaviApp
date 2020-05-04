package com.nbali.alinadi.shahabmousaviapp.models

import android.os.Parcel
import android.os.Parcelable

class Product (
    var product_id:String,
    var product_name:String,
    var product_image:String,
    var product_description:String,
    var product_link:String,
    var product_amount:String,
    var product_amount_app:String
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