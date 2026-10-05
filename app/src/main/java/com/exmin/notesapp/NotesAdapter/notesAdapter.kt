package com.exmin.notesapp.notesadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exmin.notesapp.R
import com.exmin.notesapp.notesdataclass.NotesData

class NotesAdapter(

        RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_note,
                parent,
                false
            )

    }

    override fun onBindViewHolder(
        position: Int
    ) {

            }

    override fun getItemCount(): Int {
    }
}