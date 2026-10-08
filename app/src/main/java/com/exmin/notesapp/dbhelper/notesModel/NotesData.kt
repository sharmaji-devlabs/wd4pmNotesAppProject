package com.exmin.notesapp.dbhelper.notesModel

import java.io.Serializable


data class NotesData(
    val title: String,
    val describe: String,
    var id : Int = 0,
    val timeStamp : String = ""
): Serializable