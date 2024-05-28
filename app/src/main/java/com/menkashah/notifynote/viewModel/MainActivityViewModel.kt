package com.menkashah.noteapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.menkashah.noteapp.database.DataBase
import com.menkashah.noteapp.database.Note

class MainActivityViewModel (var  appplication: Application): AndroidViewModel(appplication) {
      lateinit var notesList: LiveData<List<Note>>

    init {
        notesList = DataBase.getDB(appplication).userDao().getAllNote()
    }
}