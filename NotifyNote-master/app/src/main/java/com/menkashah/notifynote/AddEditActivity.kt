package com.menkashah.notifynote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.menkashah.noteapp.database.Note
import com.menkashah.notifynote.databinding.ActivityAddEditBinding
import java.io.Serializable

class AddEditActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityAddEditBinding.inflate(layoutInflater);
    }

    private lateinit var addEditActivityView: AddEditActivityView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        addEditActivityView = ViewModelProvider(this).get(AddEditActivityView::class.java)

        if (intent.hasExtra("NOTE_EDIT")) {
            var note: Note = intent.getSerializableExtra("NOTE_EDIT") as Note
            binding.titleNote.setText(note.title)
            binding.DescriptinNote.setText(note.description)

            binding.buttonAddNote.setOnClickListener {
                var tittle = binding.titleNote.text.toString()
                var dissp = binding.DescriptinNote.text.toString()

//                var notee = Note(title = tittle, description = dissp)
                note.title= tittle
                note.description= dissp

                addEditActivityView.update(note, this)
                finish()

            }
        } else {
            binding.buttonAddNote.setOnClickListener {
                var tittle = binding.titleNote.text.toString()
                var dissp = binding.DescriptinNote.text.toString()

                var notee = Note(title = tittle, description = dissp)

                addEditActivityView.insert(notee, this)
                finish()

            }
        }
    }
}