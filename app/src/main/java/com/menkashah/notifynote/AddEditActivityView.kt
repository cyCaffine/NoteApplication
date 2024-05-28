package com.menkashah.notifynote

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.menkashah.noteapp.database.DataBase
import com.menkashah.noteapp.database.Note
import kotlinx.coroutines.launch

class AddEditActivityView( appli: Application):AndroidViewModel(appli) {

    fun insert(note: Note, context: Context) {
        viewModelScope.launch {
            DataBase.getDB(context).userDao().insert(note)
        }
    }

    fun update(note: Note, context: Context) {
        viewModelScope.launch {
            DataBase.getDB(context).userDao().update(note)

        }

    }
}