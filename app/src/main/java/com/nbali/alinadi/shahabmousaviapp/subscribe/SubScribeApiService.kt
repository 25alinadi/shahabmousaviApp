package com.nbali.alinadi.shahabmousaviapp.subscribe

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.nbali.alinadi.shahabmousaviapp.api.ApiClient
import com.nbali.alinadi.shahabmousaviapp.api.ApiService
import com.nbali.alinadi.shahabmousaviapp.models.Subscribe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubScribeApiService(var context: Application) {
    private var apiService = ApiClient.getClient().create(ApiService::class.java)

    fun getAllSubscribes():MutableLiveData<List<Subscribe>>{
        var mutableLiveData = MutableLiveData<List<Subscribe>>()

        apiService.getAllSubscribes().enqueue(object :Callback<List<Subscribe>>{
            override fun onFailure(call: Call<List<Subscribe>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت اطلاعات اشتراک ها",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Subscribe>>, response: Response<List<Subscribe>>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }
}