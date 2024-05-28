package com.menkashah.noteapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.google.android.material.circularreveal.CircularRevealHelper.Strategy

@Dao
interface DAO {

    @Query("SELECT * FROM Note")
    fun getAllNote(): LiveData<List<Note>>

    @Delete
   suspend fun delete(note: Note)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)
}

// It is used in conjunction with the
// @Insert annotation to specify how
// conflicts should be handled when inserting a row into a database table that already contains a row with the same primary key.