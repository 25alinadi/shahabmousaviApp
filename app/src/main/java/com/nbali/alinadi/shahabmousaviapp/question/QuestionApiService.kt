package com.nbali.alinadi.shahabmousaviapp.question

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.nbali.alinadi.shahabmousaviapp.api.ApiClient
import com.nbali.alinadi.shahabmousaviapp.api.ApiService
import com.nbali.alinadi.shahabmousaviapp.models.Answer
import com.nbali.alinadi.shahabmousaviapp.models.Message
import com.nbali.alinadi.shahabmousaviapp.models.Rule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuestionApiService(var context:Application) {
    private var apiService = ApiClient.getClient().create(ApiService::class.java)

    fun getAllRules():MutableLiveData<List<Rule>>{
        var mutableLiveData = MutableLiveData<List<Rule>>()

        apiService.getAllRules().enqueue(object :Callback<List<Rule>>{
            override fun onFailure(call: Call<List<Rule>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت قوانین",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Rule>>, response: Response<List<Rule>>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun ask(title:String,text:String,product:String,type:Int):MutableLiveData<Message>{
        var mutableLiveData = MutableLiveData<Message>()

        apiService.ask(title, text, product, type).enqueue(object :Callback<Message>{
            override fun onFailure(call: Call<Message>, t: Throwable) {
                Toast.makeText(context,"مشکل در ارسال سوال",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun getAnswer():MutableLiveData<List<Answer>>{
        var mutableLiveData = MutableLiveData<List<Answer>>()

        apiService.getAnswer().enqueue(object :Callback<List<Answer>>{
            override fun onFailure(call: Call<List<Answer>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت لیست پاسخ ها",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Answer>>, response: Response<List<Answer>>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun getAllNoAnswers(role:String):MutableLiveData<List<Answer>>{
        var mutableLiveData = MutableLiveData<List<Answer>>()

        apiService.getAllNoAnswers(role).enqueue(object :Callback<List<Answer>>{
            override fun onFailure(call: Call<List<Answer>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت لیست پاسخ ها",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Answer>>, response: Response<List<Answer>>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun returnedAnswer(id:String):MutableLiveData<Message>{
        var mutableLiveData = MutableLiveData<Message>()

        apiService.returnedAnswer(id).enqueue(object :Callback<Message>{
            override fun onFailure(call: Call<Message>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت برگردندان سوال",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                mutableLiveData.value = response.body()
            }
        })

        return mutableLiveData
    }

    fun answerQuestion(id:String,answer:String):MutableLiveData<Message>{
        var mutableLiveData = MutableLiveData<Message>()

        apiService.answerQuestion(id,answer).enqueue(object :Callback<Message>{
            override fun onFailure(call: Call<Message>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت برگردندان سوال",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Message>, response: Response<Message>) {
                mutableLiveData.value = response.body()
            }

        })

        return mutableLiveData
    }

    fun getRole():MutableLiveData<Message>{
        var mutableLiveData = MutableLiveData<Message>()

        apiService.getRole().enqueue(object :Callback<Message>{
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