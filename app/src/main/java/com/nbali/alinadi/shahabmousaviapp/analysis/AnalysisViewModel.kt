package com.nbali.alinadi.shahabmousaviapp.analysis

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Analysis
import com.nbali.alinadi.shahabmousaviapp.models.AnalysisRow

class AnalysisViewModel(application: Application) : AndroidViewModel(application) {
    private var context = application
    private var analysisRepository = AnalysisRepository(context)

    fun getAllAnalysis(): LiveData<List<Analysis>> {
        return analysisRepository.getAllAnalysis()
    }

    fun getAllRows(id:String):LiveData<List<AnalysisRow>>{
        return analysisRepository.getAllRows(id)
    }
}