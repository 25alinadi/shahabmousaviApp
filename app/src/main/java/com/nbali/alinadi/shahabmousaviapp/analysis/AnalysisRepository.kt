package com.nbali.alinadi.shahabmousaviapp.analysis

import android.app.Application
import androidx.lifecycle.LiveData
import com.nbali.alinadi.shahabmousaviapp.models.Analysis
import com.nbali.alinadi.shahabmousaviapp.models.AnalysisRow

class AnalysisRepository(var context:Application) {
    private var analysisApiService = AnalysisApiService(context)

    fun getAllAnalysis():LiveData<List<Analysis>>{
        return analysisApiService.getAllAnalysis()
    }

    fun getAllRows(id:String):LiveData<List<AnalysisRow>>{
        return analysisApiService.getAllRows(id)
    }
}