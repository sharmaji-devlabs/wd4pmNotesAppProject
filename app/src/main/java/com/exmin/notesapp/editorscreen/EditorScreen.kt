package com.exmin.notesapp.editorscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.ActivityEditorScreenBinding
import com.exmin.notesapp.homescreen.HomeScreen
import com.exmin.notesapp.searchscreen.SearchScreen

class EditorScreen : AppCompatActivity() {
    private lateinit var binding: ActivityEditorScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditorScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.root.setImageResource(R.drawable.back)
        binding.eyeButton.root.setImageResource(R.drawable.live5)
        binding.saveButton.root.setImageResource(R.drawable.savefile4)





        binding.backButton.root.setOnClickListener{

            val intent = Intent(this, HomeScreen::class.java)

        val title =binding.btnTitleHeading.text.toString().trim()
        val describe = binding.btnDescriptionContain.text.toString().trim()
        intent.putExtra("title",title)
        intent.putExtra("describe",describe)
        startActivity(intent)
}
    }
}