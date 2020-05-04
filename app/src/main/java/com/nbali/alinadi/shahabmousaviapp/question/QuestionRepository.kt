package com.nbali.alinadi.shahabmousaviapp.question

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nbali.alinadi.shahabmousaviapp.models.Answer
import com.nbali.alinadi.shahabmousaviapp.models.Message
import com.nbali.alinadi.shahabmousaviapp.models.Rule

class QuestionRepository(var context:Application) {
    private var questionApiService = QuestionApiService(context)

    fun getAllRules(): LiveData<List<Rule>>{
        return questionApiService.getAllRules()
    }

    fun ask(title:String,text:String,product:String,type:Int):LiveData<Message>{
        return questionApiService.ask(title, text, product, type)
    }

    fun getAnswer():LiveData<List<Answer>>{
        return questionApiService.getAnswer()
    }

    fun getAllNoAnswers(role:String):LiveData<List<Answer>>{
        return questionApiService.getAllNoAnswers(role)
    }

    fun returnedAnswer(id:String):LiveData<Message>{
        return questionApiService.returnedAnswer(id)
    }
}