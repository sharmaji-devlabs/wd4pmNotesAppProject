package com.exmin.notesapp.notesadapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.exmin.notesapp.R
import com.exmin.notesapp.notesdataclass.NotesData

class NotesAdapter(
    private val notesList: ArrayList<NotesData>
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        val title: TextView =
            itemView.findViewById(R.id.Title)

        val description: TextView =
            itemView.findViewById(R.id.Description)

        // CardView
        val cardColor: CardView =
            itemView.findViewById(R.id.cardcolor)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_note,
                parent,
                false
            )

        return NoteViewHolder(view)
    }


    override fun onBindViewHolder(
        holder: NoteViewHolder,
        position: Int
    ) {

        val note = notesList[position]

        // Title
        holder.title.text = note.title

        // Description
        holder.description.text = note.describe


        // Note card colors
        when (position % 6) {

            0 -> {
                holder.cardColor.setCardBackgroundColor(
                    holder.itemView.context.getColor(R.color.purple)
                )
            }

            1 -> {
                holder.cardColor.setCardBackgroundColor(
                    holder.itemView.context.getColor(R.color.SoftCoralPink)
                )
            }

            2 -> {
                holder.cardColor.setCardBackgroundColor(
                    holder.itemView.context.getColor(R.color.LimeGreen)
                )
            }

            3 -> {
                holder.cardColor.setCardBackgroundColor(
                    holder.itemView.context.getColor(R.color.LimeYellow)
                )
            }

            4 -> {
                holder.cardColor.setCardBackgroundColor(
                    holder.itemView.context.getColor(R.color.Limeblue)
                )
            }

            5 -> {
                holder.cardColor.setCardBackgroundColor(
                    holder.itemView.context.getColor(R.color.Limepurple)
                )
            }
        }
    }


    override fun getItemCount(): Int {
        return notesList.size
    }
}