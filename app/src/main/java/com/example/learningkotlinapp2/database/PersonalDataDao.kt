package com.example.learningkotlinapp2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PersonalDataDao {
   @Insert
   fun insert(data: PersonalData)

    @Update
    fun update(data: PersonalData)

    @Query("select* from personal_data_table where id = :key")
    fun get(key: Int): PersonalData?

    @Query("delete from personal_data_table")
    fun clear()

    @Query("select * from personal_data_table order by id DESC")
    fun getAllData() : LiveData<List<PersonalData>>

    @Query("select * from personal_data_table order by id DESC LIMIT 1")
    fun getCurrentPersonalData() : PersonalData?
}