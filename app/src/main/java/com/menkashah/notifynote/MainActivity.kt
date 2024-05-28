package com.menkashah.notifynote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.menkashah.noteapp.database.Note
import com.menkashah.noteapp.viewModel.MainActivityViewModel
import com.menkashah.notifynote.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val bindding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var noteList : List<Note>
    lateinit var viewModel: MainActivityViewModel
     //    lateinit var noteList :List<Note>

    //    make adapter variable
    lateinit var adapter: RvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindding.root)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

       var observer = Observer<List<Note>>{
           noteList = it
           adapter= RvAdapter(noteList, this)
           bindding.rvItem.layoutManager = LinearLayoutManager(this)
           bindding.rvItem.adapter= adapter
       }
        viewModel.notesList.observe(this,observer)



        //        noteList = viewModel.notesList
        //        initialized adapter


        bindding.floatingActionButton2.setOnClickListener{
            var Intent = Intent(this@MainActivity,AddEditActivity::class.java)
            startActivity(Intent)
        }
    }
}