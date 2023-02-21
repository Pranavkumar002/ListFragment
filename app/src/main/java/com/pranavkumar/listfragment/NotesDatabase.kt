package com.pranavkumar.listfragment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [NotesEntiity::class], version = 1)
abstract class NotesDatabase : RoomDatabase(){
   abstract fun notesDao(): NotesDao

   companion object{
    lateinit var notesDatabase: NotesDatabase

       fun getDatabase(context: Context):NotesDatabase {
           if (notesDatabase == null) {
               notesDatabase = Room.databaseBuilder(
                context,
                NotesDatabase::class.java, "notes"
               ).build()
           }
           return notesDatabase
       }
    }
}
