package com.example.learningkotlinapp2.addNewProfile

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.learningkotlinapp2.database.PersonalData
import com.example.learningkotlinapp2.database.PersonalDataDao
import kotlinx.android.synthetic.main.fragment_add_new_profile.*
import kotlinx.coroutines.*

class AddNewProfileViewModel (val database: PersonalDataDao, application: Application
) : AndroidViewModel(application) {

    private val fragment by lazy {AddNewProfile()}

//    CHECKING TO SEE IF THE DATA HAS SUCCESSFULLY BEEN ADDED TO THE DATABASE AND ADDING OBSERVER.
    private var _checker= MutableLiveData<Int>()
    val checker: LiveData<Int>
            get() = _checker


    private  var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


//    This is the function is used to add the new data in the database.

    fun addNewProfile(profile: List<PersonalData>) {
        uiScope.launch {

//            val personalData = PersonalData(0L,"First Name","Second Name",25)
            val personalData = PersonalData(profile[0].id,profile[0].first_name,profile[0].second_name,profile[0].age)

                insert(personalData)
//            Log.i("Trial Name",fragment.)
            _checker.value = 1
        }
    }
    private suspend fun insert(data: PersonalData) {
        withContext(Dispatchers.IO) {
            database.insert(data)
        }
    }
    init {
        _checker.value = 0

    }
}