package com.exmin.notesapp.notesadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.ItemNoteBinding
import com.exmin.notesapp.dbhelper.notesModel.NotesData

class NotesAdapter(
    private val notesList: ArrayList<NotesData>
) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    class NoteViewHolder(val itemViewBinding: ItemNoteBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
        val itemNoteBinding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context))
//        val view = LayoutInflater.from(parent.context)
//            .inflate(
//                R.layout.item_note,
//                parent,
//                false
//            )

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
        }
    }


    override fun getItemCount(): Int {
        return notesList.size
    }
}