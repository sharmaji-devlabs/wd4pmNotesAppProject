package com.exmin.notesapp.notesadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exmin.notesapp.R
import com.exmin.notesapp.notesdataclass.NotesData

class NotesAdapter(
    private val containList: ArrayList<NotesData>
) : RecyclerView.Adapter<NotesAdapter.ContactViewHolder>() {

    // ViewHolder
    class ContactViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.Title)
        val description: TextView = itemView.findViewById(R.id.Description)
    }

    // Create ViewHolder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_note,
                parent,
                false
            )

        return ContactViewHolder(view)
    }

    // Bind data
    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {
        val currentNote = containList[position]

        holder.title.text = currentNote.title
        holder.description.text = currentNote.describe
    }

    // List size
    override fun getItemCount(): Int {
        return containList.size
    }
}