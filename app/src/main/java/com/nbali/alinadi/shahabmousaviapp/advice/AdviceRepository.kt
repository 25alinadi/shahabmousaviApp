package com.nbali.alinadi.shahabmousaviapp.advice

import android.app.Application
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Advice
import com.nbali.alinadi.shahabmousaviapp.models.Message
import com.nbali.alinadi.shahabmousaviapp.models.Timing

class AdviceRepository(var context:Application) {
    private var adviceApiService = AdviceApiService(context)

    fun getAllAdvices():LiveData<List<Advice>>{
        return adviceApiService.getAllAdvices()
    }

    fun getTiming(date:String):LiveData<Message>{
        return adviceApiService.getTiming(date)
    }

    fun insertTiming(id:String):LiveData<Message>{
        return adviceApiService.insertTiming(id)
    }

    fun getAllAdviceTimingAdmin(role:String):LiveData<List<Timing>>{
        return adviceApiService.getAllAdviceTimingAdmin(role)
    }

    fun changeRequestAdvice(id:Int,status:Int):LiveData<Message>{
        return adviceApiService.changeRequestAdvice(id, status)
    }
}