package com.example.notesApp.model;

import com.example.notesApp.model.room_database.Note;

/**
 * @Author Gaurav Naresh Pandit
 * @Since 04/01/24
 **/
public interface UpdateNoteListener {

    void editNote(Note note);

}
