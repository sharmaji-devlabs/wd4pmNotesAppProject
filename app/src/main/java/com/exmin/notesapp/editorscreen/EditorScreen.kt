package com.exmin.notesapp.editorscreen

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.ActivityEditorScreenBinding

class EditorScreen : AppCompatActivity() {

    private lateinit var binding: ActivityEditorScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityEditorScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Icons
        binding.backButton.root.setImageResource(R.drawable.back)


        // BACK BUTTON
        binding.backButton.root.setOnClickListener {

            val title =
                binding.btnTitleHeading.text.toString().trim()

            val describe =
                binding.btnDescriptionContain.text.toString().trim()


            val resultIntent = Intent()

            resultIntent.putExtra("title", title)

            resultIntent.putExtra("describe", describe)


            setResult(
                RESULT_OK,
                resultIntent
            )

            finish()
        }
        binding.eyeButton.root.setImageResource(R.drawable.live5)

        binding.saveButton.root.setImageResource(R.drawable.savefile4)
        binding.saveButton.root.setOnClickListener {

            val dialog = Dialog(this)

            dialog.setContentView(R.layout.activity_custom_dialog)
            val discard =
                dialog.findViewById<Button>(R.id.btn_discard)

            discard.setOnClickListener {
                val dialog = Dialog(this)

                dialog.setContentView(R.layout.discard_custom_dialog)
                dialog.show()
            }

            val Save= dialog.findViewById<Button>(R.id.btn_save)
            dialog.show()
        }
    }
}