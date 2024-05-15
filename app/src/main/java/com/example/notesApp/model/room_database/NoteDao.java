package com.example.notesApp.model.room_database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @Author Gaurav Naresh Pandit
 * @Since 30/12/23
 **/

@Dao
public interface NoteDao {

    @Query("SELECT * FROM  note")
    LiveData<List<Note>> getAllNote();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNotes(Note... notes);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateNote(Note note);

    @Delete
    void deleteNote(Note notes);

}
