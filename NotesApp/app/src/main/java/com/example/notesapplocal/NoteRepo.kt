package com.example.notesapplocal

import androidx.lifecycle.LiveData


class NoteRepo(private val noteDao: NoteDao){

    val allNotes : LiveData<List<Note>> = noteDao.getAllnotes()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }

}