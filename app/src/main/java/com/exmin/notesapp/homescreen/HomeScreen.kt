package com.exmin.notesapp.homescreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.exmin.notesapp.R
import com.exmin.notesapp.databinding.HomeScreenBinding
import com.exmin.notesapp.editorscreen.EditorScreen
import com.exmin.notesapp.searchscreen.SearchScreen

class HomeScreen : AppCompatActivity() {
    private lateinit var binding: HomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = HomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
//      setContentView(R.layout.home_screen)

//       setIconOnButton(
//           binding.infoButton.root,
//           R.drawable.info)
//      setIconOnButton(
//          binding.searchbutton.root,
//          R.drawable.search)
        // ViewBinding


//        // Set icons
//        binding.infoButton.root.setImageResource(R.drawable.info)
//
//
//        binding.searchbutton.root.setImageResource(R.drawable.search)
//        binding.searchbutton.root.setOnClickListener {
//
//            val intent = Intent(this, SearchScreen::class.java)
//
//            startActivity(intent)
//        }
//        binding.addbutton.root.setIconResource(R.drawable.add1)
//
//        binding.addbutton.root.setOnClickListener {
//
//            val intent = Intent(this, EditorScreen::class.java)
//
//            startActivity(intent)


//        }

//    private fun setIconOnButton(
//        button: AppCompatImageButton,
//        iconSrc: Int
//    ) {
//        button.setImageResource(iconSrc)
//    }

//  private fun setIconOnButton(iconButton : AppCompatImageButton, iconSrc : Int){
//     iconButton.setImageDrawable(getDrawable(iconSrc))
//   }


    }
}