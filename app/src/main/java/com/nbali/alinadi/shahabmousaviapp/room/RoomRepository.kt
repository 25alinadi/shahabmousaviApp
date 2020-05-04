package com.nbali.alinadi.shahabmousaviapp.room

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nbali.alinadi.shahabmousaviapp.models.Product

class RoomRepository(var productDao : ProductDao) {

    fun insert (rproduct: RProduct){
        productDao.insert(rproduct)
    }

    fun getAllProduct():LiveData<List<RProduct>>{
        return productDao.getAllProduct()
    }

    fun getSignedProduct(name:String):LiveData<RProduct>{
        return productDao.getSignedProduct(name)
    }

    fun deleteProduct(product:RProduct){
        productDao.deleteProduct(product)
    }
}