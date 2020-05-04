package com.nbali.alinadi.shahabmousaviapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    fun insert(Product:RProduct)

    @Query("SELECT * FROM RProduct")
    fun getAllProduct():LiveData<List<RProduct>>

    @Query("SELECT * FROM RProduct WHERE name IN (:name)")
    fun getSignedProduct(name:String):LiveData<RProduct>

    @Delete
    fun deleteProduct(product:RProduct)
}