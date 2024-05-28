package com.menkashah.noteapp.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
 abstract  class DataBase : RoomDatabase() {

         abstract  fun  userDao(): DAO
         companion object{
          public  var roomdb : DataBase? = null

                   fun getDB(context: Context): DataBase{
                   if(roomdb == null){
                    roomdb = Room.databaseBuilder(context,
                     DataBase::class.java,
                     "database"
                      ).allowMainThreadQueries().build()
                   }
                    return roomdb!!
                   }
         }



}