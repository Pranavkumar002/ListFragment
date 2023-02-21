package com.pranavkumar.listfragment

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NotesDao {
    @Insert
    fun insertNotes(vararg notesEntiity: NotesEntiity)

    @Query("select * from NotesEntiity")
    fun getNotes(): List<NotesEntiity>

    @Delete
    fun delete(vararg notesEntiity: NotesEntiity)

}