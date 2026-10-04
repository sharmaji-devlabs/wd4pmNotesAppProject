package com.exmin.notesapp.searchscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.SearchScreenBinding

class SearchScreen : AppCompatActivity() {
      private lateinit var binding: SearchScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = SearchScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}