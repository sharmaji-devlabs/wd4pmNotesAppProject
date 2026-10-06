package com.exmin.notesapp.activity.homescreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.HomeScreenBinding
import com.exmin.notesapp.activity.editorscreen.EditorScreen
import com.exmin.notesapp.notesadapter.NotesAdapter
import com.exmin.notesapp.dbhelper.notesModel.NotesData
import com.exmin.notesapp.searchscreen.SearchScreen

class HomeScreen : AppCompatActivity() {
    private lateinit var binding: HomeScreenBinding
    private val notesList = ArrayList<NotesData>()

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
        with(binding){
            // Toolbar icons
            infoButton.root.setImageResource(R.drawable.info)

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
                    LinearLayoutManager(this@HomeScreen)
                adapter =  NotesAdapter(notesList)
            }
        }
    }
}