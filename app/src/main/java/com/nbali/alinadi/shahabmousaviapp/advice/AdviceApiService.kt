package com.nbali.alinadi.shahabmousaviapp.advice

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.airbnb.lottie.L
import com.nbali.alinadi.shahabmousaviapp.api.ApiClient
import com.nbali.alinadi.shahabmousaviapp.api.ApiService
import com.nbali.alinadi.shahabmousaviapp.models.Advice
import com.nbali.alinadi.shahabmousaviapp.models.Message
import com.nbali.alinadi.shahabmousaviapp.models.Timing
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdviceApiService(var context:Application) {
    private var adviceApiService = ApiClient.getClient().create(ApiService::class.java)

    fun getAllAdvices():MutableLiveData<List<Advice>>{
        var mutableLiveData = MutableLiveData<List<Advice>>()

        adviceApiService.getAllAdvices().enqueue(object : Callback<List<Advice>>{
            override fun onFailure(call: Call<List<Advice>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت وقت های مشاوره",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Advice>>, response: Response<List<Advice>>) {
                mutableLiveData.value = response.body()
            }

        })

        return mutableLiveData
    }

    fun getTiming(date:String):MutableLiveData<Message>{
        var mutableLiveData = MutableLiveData<Message>()
        adviceApiService.getTiming(date).enqueue(object :Callback<Message>{
            override fun onFailure(call: Call<Message>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت وقت های مشاوره",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                mutableLiveData.value = response.body()
            }

        })

        return mutableLiveData
    }

    fun insertTiming(id:String):MutableLiveData<Message>{
        var mutableLiveData = MutableLiveData<Message>()

        adviceApiService.insertTiming(id).enqueue(object :Callback<Message>{
            override fun onFailure(call: Call<Message>, t: Throwable) {
                Toast.makeText(context,"مشکل در ثبت وقت مشاوره",Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun getAllAdviceTimingAdmin(role:String):MutableLiveData<List<Timing>>{
        var mutableLiveData = MutableLiveData<List<Timing>>()

        adviceApiService.getAllAdviceTimingAdmin(role).enqueue(object :Callback<List<Timing>>{
            override fun onFailure(call: Call<List<Timing>>, t: Throwable) {
                Toast.makeText(context,"مشکل در ارسال وقت های مشاوره",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Timing>>, response: Response<List<Timing>>) {
                mutableLiveData.value = response.body()
            }

        })

        return mutableLiveData
    }

    fun changeRequestAdvice(id:Int,status:Int):MutableLiveData<Message>{
        var mutableLiveData = MutableLiveData<Message>()

        adviceApiService.changeRequestAdvice(id,status).enqueue(object :Callback<Message>{
            override fun onFailure(call: Call<Message>, t: Throwable) {
                Toast.makeText(context,"مشکل در ارسال اطلاعات",Toast.LENGTH_SHORT).show()

            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }
}