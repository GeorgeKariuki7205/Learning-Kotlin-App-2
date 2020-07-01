package com.example.learningkotlinapp2.personalData

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.learningkotlinapp2.database.PersonalDataDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class personalDataViewModel(val database: PersonalDataDao, application: Application
) : AndroidViewModel(application) {

private  var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

}