package com.example.notesapplocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), INoteAdapter {

    private lateinit var noteText: TextInputEditText
    private lateinit var noteTextDesc: TextInputEditText
    private lateinit var notesViewModel: NoteViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteText = findViewById(R.id.fulltext)
        noteTextDesc = findViewById(R.id.full_desc)
        recyclerView = findViewById(R.id.recycle)

        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter = NotesAdapter(this,this)
        recyclerView.adapter = adapter


        val dao = NoteDatabase.getDatabase(applicationContext).getNoteDao()
        val repository = NoteRepo(dao)
        notesViewModel = ViewModelProvider(this, NoteVMFactory(repository))[NoteViewModel::class.java]

        notesViewModel.allNotes.observe(this, Observer {
            adapter.updateNotes(it)
        })
    }

    fun submitdata(view: android.view.View) {
        val noteText = noteText.text.toString()
        val noteTextDesc = noteTextDesc.text.toString()
        if ((noteText. isNotEmpty()) && (noteTextDesc.isNotEmpty())){
            notesViewModel.insertNote(Note(noteText,noteTextDesc))
            Toast.makeText(this,"Data Inserted" , Toast.LENGTH_LONG).show()

        }

    }
    override fun onItemClicked(note: Note) {
        notesViewModel.deleteNotes(note)
        Toast.makeText(this,"Data Deleted" , Toast.LENGTH_LONG).show()

    }
}
