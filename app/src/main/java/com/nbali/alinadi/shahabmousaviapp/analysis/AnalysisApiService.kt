package com.nbali.alinadi.shahabmousaviapp.analysis

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.nbali.alinadi.shahabmousaviapp.api.ApiClient
import com.nbali.alinadi.shahabmousaviapp.api.ApiService
import com.nbali.alinadi.shahabmousaviapp.models.Analysis
import com.nbali.alinadi.shahabmousaviapp.models.AnalysisRow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnalysisApiService(var context:Application) {
    private var apiService = ApiClient.getClient().create(ApiService::class.java)

    fun getAllAnalysis():MutableLiveData<List<Analysis>>{
        var mutableLiveData = MutableLiveData<List<Analysis>>()

        apiService.getAllAnalysis().enqueue(object :Callback<List<Analysis>>{
            override fun onFailure(call: Call<List<Analysis>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت سبد های تحلیل",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Analysis>>, response: Response<List<Analysis>>) {
                mutableLiveData.value = response.body()
            }

        })

        return mutableLiveData
    }

    fun getAllRows(id:String):MutableLiveData<List<AnalysisRow>>{
        var mutableLiveData = MutableLiveData<List<AnalysisRow>>()

        apiService.getAllRows(id).enqueue(object :Callback<List<AnalysisRow>>{
            override fun onFailure(call: Call<List<AnalysisRow>>, t: Throwable) {
                Toast.makeText(context,"مشکل در دریافت اطلاعات سبد تحلیل",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<AnalysisRow>>, response: Response<List<AnalysisRow>>) {
                mutableLiveData.value = response.body()
            }

        })

        return mutableLiveData
    }
}