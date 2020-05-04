package com.nbali.alinadi.shahabmousaviapp.post

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.nbali.alinadi.shahabmousaviapp.api.ApiClient
import com.nbali.alinadi.shahabmousaviapp.api.ApiService
import com.nbali.alinadi.shahabmousaviapp.models.Post
import com.nbali.alinadi.shahabmousaviapp.models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostApiService(var context:Application) {
    private var apiService = ApiClient.getClient().create(ApiService::class.java)

    fun getAllProducts():MutableLiveData<List<Product>>{
        var mutableLiveData = MutableLiveData<List<Product>>()

        apiService.getAllProducts().enqueue(object :Callback<List<Product>>{
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت اطلاعات محصولات",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun getAllProductsTitle():MutableLiveData<List<Product>>{
        var mutableLiveData = MutableLiveData<List<Product>>()

        apiService.getAllProducts().enqueue(object :Callback<List<Product>>{
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت اطلاعات محصولات",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun getAllPosts():MutableLiveData<List<Post>>{
        var mutableLiveData = MutableLiveData<List<Post>>()

        apiService.getAllPosts().enqueue(object :Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت پست ها",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                mutableLiveData.value = response.body()
                Log.i("LOG", response.body()!!.size.toString())
            }
        })

        return mutableLiveData
    }
}