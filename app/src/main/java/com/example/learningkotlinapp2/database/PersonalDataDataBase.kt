package com.example.learningkotlinapp2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonalData::class], version = 1, exportSchema = false)
abstract class PersonalDataDataBase :RoomDatabase(){
    abstract  val personalDataDao: PersonalDataDao

    companion object{
        @Volatile
        private var INSTANCE: PersonalDataDataBase? = null

        fun getInstance(context: Context): PersonalDataDataBase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PersonalDataDataBase::class.java,
                        "personal_data_history_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}