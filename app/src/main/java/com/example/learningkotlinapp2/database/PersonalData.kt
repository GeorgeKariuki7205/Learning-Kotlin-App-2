package com.example.learningkotlinapp2.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "personal_data_table")
data class PersonalData (

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "first_name")
    var first_name : String,
    @ColumnInfo(name = "second_name")
    var second_name: String,
    @ColumnInfo(name = "age")
    var age: Int,
    @ColumnInfo(name = "start_time")
    val startTime: Long = System.currentTimeMillis(),
    @ColumnInfo(name = "end_time")
    var endTime: Long = startTime,
    @ColumnInfo(name = "youth")
    var youth: Int = -1

)