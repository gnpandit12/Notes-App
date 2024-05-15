package com.example.notesApp.model.room_database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @Author Gaurav Naresh Pandit
 * @Since 30/12/23
 **/

@Database(entities = {Note.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();

}
