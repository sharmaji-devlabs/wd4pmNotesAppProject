package com.exmin.notesapp.activity.editorscreen

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.ActivityEditorScreenBinding
import com.exmin.notesapp.activity.homescreen.HomeScreen

class EditorScreen : AppCompatActivity() {
    private lateinit var binding: ActivityEditorScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditorScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val dialog = Dialog(this@EditorScreen)

        dialog.setContentView(R.layout.activity_custom_dialog)
        val discard = dialog.findViewById<Button>(R.id.btn_discard)
        discard.setOnClickListener {
            dialog.dismiss()
            val cnfDialog = Dialog(this@EditorScreen)

            cnfDialog.setContentView(R.layout.discard_custom_dialog)

        }

        with(binding) {
            backButton.root.setImageResource(R.drawable.back)
            backButton.root.setOnClickListener {
                val title = btnTitleHeading.text.toString().trim()
                val describe = btnDescriptionContain.text.toString().trim()
                // send data into database
                finish()
            }
            eyeButton.root.setImageResource(R.drawable.live5)
            saveButton.root.setImageResource(R.drawable.savefile4)

            saveButton.root.setOnClickListener {
                dialog.show()
            }

        }

    }
}
