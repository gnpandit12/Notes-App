package com.example.notesApp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesApp.databinding.ActivityMainBinding;
import com.example.notesApp.model.NotestAdapter;
import com.example.notesApp.model.UpdateNoteListener;
import com.example.notesApp.model.room_database.Note;
import com.example.notesApp.viewModel.NoteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, UpdateNoteListener {

    private FloatingActionButton floatingActionButton;
    private RecyclerView notesRecyclerView;
    private NotestAdapter notestAdapter;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        floatingActionButton = activityMainBinding.addNotesFab;
        notesRecyclerView = activityMainBinding.notesRecyclerView;

        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesRecyclerView.setHasFixedSize(true);

        floatingActionButton.setOnClickListener(this);


        noteViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(NoteViewModel.class);

        noteViewModel.getAllNotes().observe(this, notes -> {
            notestAdapter = new NotestAdapter(notes, this);
            notesRecyclerView.setAdapter(notestAdapter);
            notestAdapter.notifyDataSetChanged();
        });

    }

    @Override
    public void onClick(View view) {
        if (view == floatingActionButton) {
            Intent intent = new Intent(this, AddNoteActivity.class);
            intent.putExtra("Type", "Insert");
            startActivity(intent);
        }
    }

    @Override
    public void editNote(Note note) {
        Intent intent = new Intent(this, AddNoteActivity.class);
        intent.putExtra("Type", "Update");
        intent.putExtra("current_note", note);
        startActivity(intent);
    }
}