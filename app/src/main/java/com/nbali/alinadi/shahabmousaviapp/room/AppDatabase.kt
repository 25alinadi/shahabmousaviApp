package com.nbali.alinadi.shahabmousaviapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RProduct::class],version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun productDao():ProductDao
    companion object{
        private var instance:AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase{
            if(instance != null){
                return instance!!
            }else{
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,"product_mousavi"
                ).allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}