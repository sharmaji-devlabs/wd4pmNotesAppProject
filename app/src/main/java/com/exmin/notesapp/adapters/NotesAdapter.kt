package com.exmin.notesapp.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exmin.notesapp.R
import com.exmin.notesapp.activity.samplenote.Sample_Note
import com.exmin.notesapp.databinding.ItemNoteBinding
import com.exmin.notesapp.dbhelper.NotesDBHelper
import com.exmin.notesapp.dbhelper.notesModel.NotesData

class NotesAdapter(
    val context: Context,

) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    private var notesList: MutableList<NotesData>
    init {
        notesList = NotesDBHelper(context).getALLNotes()
        Log.i("NOTES", "TOTAL NOTES ARE : ${notesList.size}")
    }


    fun loadNotes(context: Context){
        notesList.clear()
        notesList.addAll(NotesDBHelper(context).getALLNotes())
        for (note in notesList){
            Log.i("NOTES", note.toString())
        }
    }

    fun getNotesSize()= notesList.size

    class NoteViewHolder(val itemViewBinding: ItemNoteBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
        val itemNoteBinding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context))

        return NoteViewHolder(itemNoteBinding)
    }


    override fun onBindViewHolder(
        holder: NoteViewHolder,
        position: Int
    ) {

        val note = notesList[position]

        // Note card colors
        val colorRef = when (position % 6) {


            1 ->

                holder.itemView.context.getColor(R.color.SoftCoralPink)

            2 ->
                holder.itemView.context.getColor(R.color.LimeGreen)

            3 ->
                holder.itemView.context.getColor(R.color.LimeYellow)

            4 ->
                holder.itemView.context.getColor(R.color.Limeblue)

            5 ->
                holder.itemView.context.getColor(R.color.Limepurple)

            else ->
                holder.itemView.context.getColor(R.color.purple)

        }

        with(holder.itemViewBinding){
            root.setCardBackgroundColor(colorRef)
            noteTitle.text = note.title

            root.setOnClickListener {
                context.startActivity(Intent(context, Sample_Note::class.java).apply {
                    putExtra("NOTES", note)
                })
            }
        }
    }


    override fun getItemCount(): Int {
        return getNotesSize()
    }
}