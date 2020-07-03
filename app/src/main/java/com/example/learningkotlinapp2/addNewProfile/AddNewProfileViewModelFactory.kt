package com.example.learningkotlinapp2.addNewProfile

import android.app.Application
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learningkotlinapp2.database.PersonalDataDao

class AddNewProfileViewModelFactory(
    private val dataSource: PersonalDataDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddNewProfileViewModel::class.java)) {
            return AddNewProfileViewModel(dataSource, application) as T
            Log.i("AddNewProfileViewModel."," AddNewProfileViewModel  Factory Added Successfully.")
        }
        throw IllegalArgumentException(" AddNewProfileViewModel Unknown ViewModel class")
    }
}