package com.example.notesApp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.notesApp.databinding.ActivityAddNoteBinding;
import com.example.notesApp.model.room_database.Note;
import com.example.notesApp.viewModel.NoteViewModel;

import java.util.Objects;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText addNoteTitleEditText;
    private EditText addNoteDescEditText;
    private Button saveNoteButton;

    private String type;
    private NoteViewModel noteViewModel;
    private Note mNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.notesApp.databinding.ActivityAddNoteBinding activityAddNoteBinding = ActivityAddNoteBinding.inflate(getLayoutInflater());
        setContentView(activityAddNoteBinding.getRoot());

        saveNoteButton = activityAddNoteBinding.saveNoteButton;

        addNoteTitleEditText = activityAddNoteBinding.enterNoteTitleEditText;
        addNoteDescEditText = activityAddNoteBinding.enterNoteDescriptionEditText;

        noteViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(NoteViewModel.class);


        saveNoteButton.setOnClickListener(this);

        type = Objects.requireNonNull(getIntent().getExtras()).getString("Type");

        if (getIntent().getSerializableExtra("current_note") != null) {
            this.mNote = (Note) getIntent().getSerializableExtra("current_note");
             addNoteTitleEditText.setText(mNote.getNoteTitle());
             addNoteDescEditText.setText(mNote.getNoteDescription());
        }

    }

    @Override
    public void onClick(View view) {
        if (view == saveNoteButton) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("note_title", addNoteTitleEditText.getText().toString().trim());
            intent.putExtra("note_description", addNoteDescEditText.getText().toString().trim());
            if (Objects.equals(type, "Insert")) {
                Note note = new Note(addNoteTitleEditText.getText().toString().trim(), addNoteDescEditText.getText().toString().trim());
                noteViewModel.insertNote(note);
            } else if (Objects.equals(type, "Update")){
                mNote.setNoteTitle(addNoteTitleEditText.getText().toString().trim());
                mNote.setNoteDescription(addNoteDescEditText.getText().toString().trim());
                noteViewModel.updateNote(mNote);
            }
            startActivity(intent);
        }
    }

}