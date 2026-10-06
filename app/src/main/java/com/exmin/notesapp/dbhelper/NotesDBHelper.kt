package com.exmin.notesapp.dbhelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.exmin.notesapp.dbhelper.notesModel.NotesData

class NotesDBHelper(val context: Context) : SQLiteOpenHelper(context, DATABASENAME, null, INITIAL_VERSION) {

    companion object{
        private val DATABASENAME = "NOTESDB.db"
        private val INITIAL_VERSION = 1

        // table field
        private val NOTE_TITLE = "title"
        private val NOTE_DESCRIPTION = "notes_description"
        private val NOTE_ID = "id"

        private val UPDATE_TIME = "update_time"
        private val TABLE_NAME = "Notes"
        // TABLE CREATION QUERY
        private val TABLE_CREATION = """
            CREATE TABLE IF NOT EXISTS $TABLE_NAME ( $NOTE_ID INTEGER PRIMARY KEY AUTO_INCREMENT, $NOTE_TITLE VARCHAR(255) NOT NULL, $NOTE_DESCRIPTION TEXT, $UPDATE_TIME DATETIME DEFAULT CURRENT_TIMESTAMP
        """.trimIndent()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(TABLE_CREATION)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("""DROP TABLE IF EXISTS $TABLE_NAME""")
        onCreate(db)
    }

    // INSERT METHOD
    fun notesInsert(note : NotesData){
        val db = writableDatabase

        db.execSQL("""
            INSERT INTO $TABLE_NAME ($NOTE_ID, $NOTE_TITLE, $NOTE_DESCRIPTION)
            VALUES 
            (${note.id}, '${note.title}', '${note.describe}')
        """.trimIndent())

    }

    fun updateNotes(note: NotesData){
        if (note.id == 0){
            Log.d("DATABASE UPDATE EXCEPTION", "NOTE ID IS ${note.id}")
            return
        }
        writableDatabase.apply {
            execSQL("""
                UPDATE $TABLE_NAME 
                SET $NOTE_TITLE = ${note.title},
                $NOTE_DESCRIPTION = ${note.describe}
                WHERE $NOTE_ID =${note.id}
            """.trimIndent())
        }
    }

    fun deleteNote(id: Int){
        writableDatabase.apply {
            execSQL("""
                DELETE FROM $TABLE_NAME
                WHERE $NOTE_ID = $id
            """.trimIndent())
        }
    }

}