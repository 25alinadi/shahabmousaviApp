package com.nbali.alinadi.shahabmousaviapp.question

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Answer
import com.nbali.alinadi.shahabmousaviapp.models.Message
import com.nbali.alinadi.shahabmousaviapp.models.Rule

class QuestionViewModel(application: Application) : AndroidViewModel(application) {
    private var context = application
    private var questionRepository = QuestionRepository(context)

    fun getAllRules(): LiveData<List<Rule>> {
        return questionRepository.getAllRules()
    }

    fun ask(title:String,text:String,product:String,type:Int):LiveData<Message>{
        return questionRepository.ask(title, text, product, type)
    }

    fun getAnswer():LiveData<List<Answer>>{
        return questionRepository.getAnswer()
    }

    fun getAllNoAnswers(role:String):LiveData<List<Answer>>{
        return questionRepository.getAllNoAnswers(role)
    }

    fun returnedAnswer(id:String):LiveData<Message>{
        return questionRepository.returnedAnswer(id)
    }
}