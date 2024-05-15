package com.example.notesApp.model.room_database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

/**
 * @Author Gaurav Naresh Pandit
 * @Since 30/12/23
 **/

@Entity
public class Note implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    private String noteTitle;
    private String noteDescription;

    public Note(String noteTitle, String noteDescription) {
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }


}
