package com.exmin.notesapp.editorscreen

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.ActivityEditorScreenBinding
import com.exmin.notesapp.homescreen.HomeScreen

class EditorScreen : AppCompatActivity() {
    private lateinit var binding: ActivityEditorScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditorScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.root.setImageResource(R.drawable.back)

        binding.backButton.root.setOnClickListener{
            val intent = Intent(this, HomeScreen::class.java)
            val title =binding.btnTitleHeading.text.toString().trim()
            val describe = binding.btnDescriptionContain.text.toString().trim()

            intent.putExtra("title",title)
            intent.putExtra("describe",describe)

            startActivity(intent)
        }
        binding.eyeButton.root.setImageResource(R.drawable.live5)
        binding.saveButton.root.setImageResource(R.drawable.savefile4)

            binding.saveButton.root.setOnClickListener {

                val dialog = Dialog(this)

                dialog.setContentView(R.layout.activity_custom_dialog)
                 val discard =dialog.findViewById<Button>(R.id.btn_discard)
                discard.setOnClickListener {
                    val dialog = Dialog(this)

                    dialog.setContentView(R.layout.discard_custom_dialog)
                }
                dialog.show()
            }
        }
    }
