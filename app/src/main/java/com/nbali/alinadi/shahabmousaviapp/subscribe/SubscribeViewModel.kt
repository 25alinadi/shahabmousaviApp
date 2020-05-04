package com.nbali.alinadi.shahabmousaviapp.subscribe

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Subscribe

class SubscribeViewModel(application: Application) : AndroidViewModel(application) {
    var context = application
    private var subscribeRepository = SubscribeRepository(context)

    fun getAllSubscribes(): LiveData<List<Subscribe>> {
        return subscribeRepository.getAllSubscribes()
    }
}