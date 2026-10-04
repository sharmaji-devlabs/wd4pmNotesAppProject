package com.exmin.notesapp.homescreen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.exmin.notesapp.databinding.SampleNoteBinding


class Sample_Note:AppCompatActivity() {
    private lateinit var binding: SampleNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = SampleNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.root.setImageResource(com.exmin.notesapp.R.drawable.back)
        binding.noteButton.root.setImageResource(com.exmin.notesapp.R.drawable.savefile4)
    }
}