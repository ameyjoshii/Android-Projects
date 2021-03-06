package com.example.notesapplocal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private  val context: Context, private  val listener: INoteAdapter): RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    var allNotes = ArrayList<Note>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textView: TextView = itemView.findViewById(R.id.TitleNote)
        val desctextView: TextView = itemView.findViewById(R.id.DescNote)
        val deleteButton: ImageView = itemView.findViewById(R.id.deletebutton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val ViewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false))
        ViewHolder.deleteButton.setOnClickListener {
            listener.onItemClicked(allNotes[ViewHolder.adapterPosition])
        }
        return ViewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.textView.text = allNotes[holder.adapterPosition].text
        holder.desctextView.text = allNotes[holder.adapterPosition].desc

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateNotes(notesList: List<Note>){
        allNotes.clear()
        allNotes.addAll(notesList)

        notifyDataSetChanged()
    }
}

interface INoteAdapter{
    fun onItemClicked(note: Note)
}
