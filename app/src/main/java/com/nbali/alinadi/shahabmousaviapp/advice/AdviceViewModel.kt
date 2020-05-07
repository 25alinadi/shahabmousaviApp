package com.nbali.alinadi.shahabmousaviapp.advice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Advice
import com.nbali.alinadi.shahabmousaviapp.models.Message
import com.nbali.alinadi.shahabmousaviapp.models.Timing

class AdviceViewModel(application: Application) : AndroidViewModel(application) {
    private var context = application
    private var adviceRepository = AdviceRepository(context)

    fun getAllAdvices(): LiveData<List<Advice>> {
        return adviceRepository.getAllAdvices()
    }

    fun getTiming(date:String):LiveData<Message>{
        return adviceRepository.getTiming(date)
    }

    fun insertTiming(id:String):LiveData<Message>{
        return adviceRepository.insertTiming(id)
    }

    fun getAllAdviceTimingAdmin(role:String):LiveData<List<Timing>>{
        return adviceRepository.getAllAdviceTimingAdmin(role)
    }

    fun changeRequestAdvice(id:Int,status:Int):LiveData<Message>{
        return adviceRepository.changeRequestAdvice(id, status)
    }
}