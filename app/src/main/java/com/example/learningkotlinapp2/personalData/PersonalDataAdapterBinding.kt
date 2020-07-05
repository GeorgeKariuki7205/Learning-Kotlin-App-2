package com.example.learningkotlinapp2.personalData

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.learningkotlinapp2.database.PersonalData

@BindingAdapter("name")
fun TextView.setName(item: PersonalData){
    text = item.first_name+ "   " + item.second_name
}
@BindingAdapter("age")
fun TextView.setAge(item: PersonalData){
    text = item.age.toString()
}

@BindingAdapter("ageGroup")
fun TextView.setAgeGroup(item: PersonalData){
    text = "20-30"
}
