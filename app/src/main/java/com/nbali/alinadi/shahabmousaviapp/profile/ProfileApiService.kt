package com.nbali.alinadi.shahabmousaviapp.profile

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.nbali.alinadi.shahabmousaviapp.api.ApiClient
import com.nbali.alinadi.shahabmousaviapp.api.ApiService
import com.nbali.alinadi.shahabmousaviapp.models.Message
import com.nbali.alinadi.shahabmousaviapp.models.Info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileApiService(var context:Application) {
    private var apiService = ApiClient.getClient().create(ApiService::class.java)

    fun registerUser(firstName:String,lastName:String,email:String,password:String,phone:String,gender:Int):MutableLiveData<Message>{
        var mutableLiveData = MutableLiveData<Message>()

        apiService.registerUser(firstName,lastName,email,password,phone,gender).enqueue(object :Callback<Message>{
            override fun onFailure(call: Call<Message>, t: Throwable) {
                Toast.makeText(context,"مشکل در ارسال اطلاعات کاربر",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                mutableLiveData.value = response.body()
            }

        })

        return mutableLiveData
    }

    fun loginUser(email:String,password:String):MutableLiveData<Message>{
        var mutableLiveData = MutableLiveData<Message>()

        apiService.loginUser(email,password).enqueue(object :Callback<Message>{
            override fun onFailure(call: Call<Message>, t: Throwable) {
                Toast.makeText(context,"خطا در ورود به حساب کاربری",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                mutableLiveData.value = response.body()
            }

        })

        return mutableLiveData
    }

    fun firstPage():MutableLiveData<Info>{
        var mutableLiveData = MutableLiveData<Info>()

        apiService.firstPage().enqueue(object :Callback<Info>{
            override fun onFailure(call: Call<Info>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت اطلاعات",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Info>, response: Response<Info>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun contactUs():MutableLiveData<Info>{
        var mutableLiveData = MutableLiveData<Info>()

        apiService.contactUs().enqueue(object :Callback<Info>{
            override fun onFailure(call: Call<Info>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت اطلاعات",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Info>, response: Response<Info>) {
                mutableLiveData.value = response.body()
                Log.i("LOG",response.body()!!.insta_link)
            }
        })

        return mutableLiveData
    }
}