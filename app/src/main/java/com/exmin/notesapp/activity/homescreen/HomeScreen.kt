package com.exmin.notesapp.activity.homescreen

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmin.notesapp.adapters.NotesAdapter
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.HomeScreenBinding
import com.exmin.notesapp.activity.editorscreen.EditorScreen
import com.exmin.notesapp.dbhelper.NotesDBHelper
import com.exmin.notesapp.searchscreen.SearchScreen

class HomeScreen : AppCompatActivity() {
    private lateinit var binding: HomeScreenBinding
    private lateinit var dbHelper: NotesDBHelper

    private lateinit var adapter: NotesAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        dbHelper = NotesDBHelper(this@HomeScreen)
        adapter = NotesAdapter(this@HomeScreen)
        with(binding){
            // Toolbar icons
            infoButton.root.apply {
                setImageResource(R.drawable.info)
                setOnClickListener {
                    Dialog(this@HomeScreen).apply {
                        setContentView(R.layout.dialog_info)
                        window?.setBackgroundDrawable(this@HomeScreen.getDrawable(R.drawable.custom_dialog_background))
                    }.show()
                }
            }

            addbutton.root.apply {
                setIconResource(R.drawable.add1)
                setOnClickListener {
                    startActivity(Intent(this@HomeScreen, EditorScreen::class.java))
                }
            }

            // Search button
            searchbutton.root.apply {
                setImageResource(R.drawable.search)
                setOnClickListener {
                    startActivity(Intent(this@HomeScreen, SearchScreen::class.java))
                }
            }

            recyclerView.apply {
                layoutManager =
                    LinearLayoutManager(this@HomeScreen, LinearLayoutManager.VERTICAL, false)
                adapter =  this@HomeScreen.adapter
            }


            // CONTROLLING VISIBILITY OF CREATE FIRST NOTES
            createYourFirstNote.visibility = if (specifyCreateNoteVisibliy()) View.GONE else View.VISIBLE
        }
    }

    fun specifyCreateNoteVisibliy() = if (adapter.getNotesSize() > 0) true else false


    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        adapter.loadNotes(this@HomeScreen)
        adapter.notifyDataSetChanged()
    }

}