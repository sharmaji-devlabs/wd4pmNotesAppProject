package com.exmin.notesapp.activity.samplenote

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exmin.notesapp.R
import com.exmin.notesapp.activity.editorscreen.EditorScreen
import com.exmin.notesapp.databinding.SampleNoteBinding
import com.exmin.notesapp.dbhelper.notesModel.NotesData

class Sample_Note : AppCompatActivity() {
    private lateinit var binding: SampleNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = SampleNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding) {
            val notes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra("NOTES", NotesData::class.java)
            } else {
                null
            }
            txtTitle.text = notes?.title ?: "Title not found"
            txtDescription.text = notes?.describe ?: "Description Not found"
            btnBack.root.apply {
             setImageResource(R.drawable.back)
                setOnClickListener {
                    finish()
                }
            }
            btnEditNote.root.apply {
                setImageResource(R.drawable.icon_edit)
                setOnClickListener {
                    startActivity(Intent(this@Sample_Note, EditorScreen::class.java).apply {
                        putExtra("NOTES", notes)
                    })
                }
            }



        }
    }
}