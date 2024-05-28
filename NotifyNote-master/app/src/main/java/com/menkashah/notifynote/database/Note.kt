package com.menkashah.noteapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int?=null,
    var title:String,
    var description:String
):Serializable