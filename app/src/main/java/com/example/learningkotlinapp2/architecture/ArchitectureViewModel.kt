package com.example.learningkotlinapp2.architecture

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArchitectureViewModel: ViewModel(){
    private var value= MutableLiveData<Int>()
    val liveValue: LiveData<Int>
            get() = value
    init {
            value.value = 0
    }

    //    Function to throw when clicking ADD.

        fun add(){
            value.value = value.value?.plus(5)
            Log.i("ArchitectureAdd", liveValue.value.toString()+" This is the Value")
        }
    fun subtract(){
        value.value = value.value?.minus(5)
        Log.i("ArchitectureAdd", liveValue.value.toString()+" This is the Value")
    }
    //    Function to throw when clicking SUBTRACT.

}