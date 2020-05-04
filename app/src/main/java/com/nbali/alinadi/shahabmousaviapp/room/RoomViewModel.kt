package com.nbali.alinadi.shahabmousaviapp.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Product

class RoomViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var repository:RoomRepository

    init {
        var productDao = AppDatabase.getDatabase(application).productDao()
        repository = RoomRepository(productDao)
    }

    fun insert(rProduct:RProduct){
        repository.insert(rProduct)
    }

    fun getAllProduct():LiveData<List<RProduct>>{
        return repository.getAllProduct()
    }

    fun getSignedProduct(name:String):LiveData<RProduct>{
        return repository.getSignedProduct(name)
    }

    fun deleteProduct(product:RProduct){
        repository.deleteProduct(product)
    }
}