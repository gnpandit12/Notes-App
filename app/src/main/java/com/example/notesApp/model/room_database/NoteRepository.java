package com.example.notesApp.model.room_database;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

/**
 * @Author Gaurav Naresh Pandit
 * @Since 30/12/23
 **/
public class NoteRepository {

    AppDatabase appDatabase;
    NoteDao noteDao;
    private LiveData<List<Note>> listData;

    public NoteRepository(Context context) {
        appDatabase = Room.databaseBuilder(context, AppDatabase.class, "database_name")
                .fallbackToDestructiveMigration()
                .build();

        noteDao = appDatabase.noteDao();
        listData = noteDao.getAllNote();

    }

    public void insertNote(Note note) {
        noteDao.insertNotes(note);
    }

    public void updateNote(Note note) {
        noteDao.updateNote(note);
    }

    public LiveData<List<Note>> getAllNotes(){
        return listData;
    }

}
