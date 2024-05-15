package com.example.notesApp.viewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notesApp.model.room_database.Note;
import com.example.notesApp.model.room_database.NoteRepository;

import java.util.List;

/**
 * @Author Gaurav Naresh Pandit
 * @Since 30/12/23
 **/
public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private final LiveData<List<Note>> noteList;
    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRepository = new NoteRepository(application);
        noteList = noteRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return noteList;
    }

    public void insertNote(Note note) {
        AsyncTask.execute(() -> noteRepository.insertNote(note));
    }

    public void updateNote(Note note) {
        AsyncTask.execute(() -> noteRepository.updateNote(note));
    }

}
