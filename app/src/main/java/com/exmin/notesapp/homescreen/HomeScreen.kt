package com.exmin.notesapp.homescreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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


    // EditorScreen se result receive karega
    private val editorLauncher =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->

            if (result.resultCode == RESULT_OK) {

                val data = result.data

                val title =
                    data?.getStringExtra("title") ?: ""

                val description =
                    data?.getStringExtra("describe") ?: ""


                // Empty note add nahi karna
                if (title.isNotEmpty() || description.isNotEmpty()) {

                    val note = NotesData(
                        title = title,
                        description = description
                    )

                    notesList.add(note)

                    adapter.notifyItemInserted(
                        notesList.size - 1
                    )
                }
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding =
            HomeScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)


        // Icons
        binding.infoButton.root.setImageResource(
            R.drawable.info
        )

        binding.searchbutton.root.setImageResource(
            R.drawable.search
        )

        binding.addbutton.root.setIconResource(
            R.drawable.add1
        )


        // RecyclerView
        adapter = NotesAdapter(notesList)

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this)

        binding.recyclerView.adapter = adapter


        // Search
        binding.searchbutton.root.setOnClickListener {

            val intent =
                Intent(this, SearchScreen::class.java)

            startActivity(intent)
        }


        // ADD NOTE
        binding.addbutton.root.setOnClickListener {

            val intent =
                Intent(this, EditorScreen::class.java)

            editorLauncher.launch(intent)
        }
    }
}