package com.exmin.notesapp.homescreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.HomeScreenBinding
import com.exmin.notesapp.editorscreen.EditorScreen
import com.exmin.notesapp.notesadapter.NotesAdapter
import com.exmin.notesapp.notesdataclass.NotesData
import com.exmin.notesapp.searchscreen.SearchScreen

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: HomeScreenBinding

    private lateinit var adapter: NotesAdapter

    private val notesList = ArrayList<NotesData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = HomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toolbar icons
        binding.infoButton.root.setImageResource(R.drawable.info)

        binding.searchbutton.root.setImageResource(R.drawable.search)

        binding.addbutton.root.setIconResource(R.drawable.add1)


        // Search button
        binding.searchbutton.root.setOnClickListener {

            val intent = Intent(this, SearchScreen::class.java)

            startActivity(intent)
        }


        // Add button
        binding.addbutton.root.setOnClickListener {

            val intent = Intent(this, EditorScreen::class.java)

            startActivity(intent)
        }


        // RecyclerView setup
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this)

        adapter = NotesAdapter(notesList)

        binding.recyclerView.adapter = adapter


        // Get data from EditorScreen
        val title = intent.getStringExtra("title") ?: ""

        val describe = intent.getStringExtra("describe") ?: ""


        // Add note if data exists
        if (title.isNotEmpty() || describe.isNotEmpty()) {

            val note = NotesData(
                title = title,
                describe = describe
            )

            notesList.add(note)

            adapter.notifyItemInserted(notesList.size - 1)
        }
    }
}