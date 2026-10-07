package com.exmin.notesapp.activity.editorscreen

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.ActivityEditorScreenBinding
import com.exmin.notesapp.dbhelper.NotesDBHelper
import com.exmin.notesapp.dbhelper.notesModel.NotesData

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

        val reConfirmationDialog = confirmationDialog("Are your sure Do you want to discard?", {

        }, {
            finish()
        })


        val confirmDialog = confirmationDialog("Do you want to save?", {
            saveNotes()
            finish()
        },
            {
                reConfirmationDialog.show()
            }, "Save")

        with(binding) {
            backButton.root.setImageResource(R.drawable.back)
            backButton.root.setOnClickListener {

                confirmDialog.show()

            }
            eyeButton.root.setImageResource(R.drawable.live5)
            saveButton.root.apply {
                setImageResource(R.drawable.savefile4)
                setOnClickListener {
                    saveNotes()
                    finish()
                }
            }

        }

    }

    private fun saveNotes(){
        val title = binding.btnTitleHeading.text.toString().trim()
        val describe = binding.btnDescriptionContain.text.toString().trim()
        val dbHelper = NotesDBHelper(this@EditorScreen)
        dbHelper.notesInsert(NotesData(title = title, describe = describe))
    }

    private fun confirmationDialog(message: String, onSuccess: () -> Unit, onCancel: () -> Unit, saveBtnTitle: String = "") :Dialog{
        val confirmDialog = Dialog(this@EditorScreen)

        confirmDialog.setContentView(R.layout.dialog_confirmation)

        confirmDialog.setCancelable(false)

        confirmDialog.window?.setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background))

        val messageTxt: TextView = confirmDialog.findViewById(R.id.dialog_message)
        messageTxt.text = message

        val dismissBtn: Button = confirmDialog.findViewById(R.id.dialog_btn_discard)
        dismissBtn.setOnClickListener {
            onCancel()
            confirmDialog.dismiss()
        }

        val saveBtn : Button = confirmDialog.findViewById(R.id.dialog_btn_save)
        saveBtn.text = if (saveBtnTitle.isEmpty()) saveBtn.text else saveBtnTitle
        saveBtn.setOnClickListener {
            onSuccess()
            confirmDialog.dismiss()
        }

        return confirmDialog

    }


}