package com.exmin.notesapp.activity.samplenote

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.SampleNoteBinding

class Sample_Note: AppCompatActivity() {
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

        binding.btnBack.root.setImageResource(R.drawable.back)
        binding.noteButton.root.setImageResource(R.drawable.savefile4)
    }
}