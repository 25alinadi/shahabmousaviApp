package com.nbali.alinadi.shahabmousaviapp.subscribe

import android.app.Application
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Subscribe

class SubscribeRepository(context:Application) {
    private var subscribeApiService = SubScribeApiService(context)

    fun getAllSubscribes():LiveData<List<Subscribe>>{
        return subscribeApiService.getAllSubscribes()
    }
}