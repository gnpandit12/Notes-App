package com.example.notesApp.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesApp.R;
import com.example.notesApp.model.room_database.Note;

import java.util.List;

/**
 * @Author Gaurav Naresh Pandit
 * @Since 21/12/23
 **/
public class NotestAdapter extends RecyclerView.Adapter<NotestAdapter.NotesViewHolder>  {

    private final List<Note> mNoteDataClassArrayList;
    private final UpdateNoteListener mUpdateNoteListener;

    public NotestAdapter(List<Note> noteDataList, UpdateNoteListener updateNoteListener) {
        this.mUpdateNoteListener = updateNoteListener;
        this.mNoteDataClassArrayList = noteDataList;
    }



    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_card_view, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {

        Note note = mNoteDataClassArrayList.get(position);

        String title = mNoteDataClassArrayList.get(position).getNoteTitle();
        String desc = mNoteDataClassArrayList.get(position).getNoteDescription();

        holder.noteTitleTextView.setText(note.getNoteTitle());
        holder.noteDescriptionTextView.setText(note.getNoteDescription());

        holder.editImageView.setOnClickListener(view -> mUpdateNoteListener.editNote(note));

    }


    public static class NotesViewHolder extends RecyclerView.ViewHolder {

        private TextView noteTitleTextView;
        private TextView noteDescriptionTextView;
        private ImageView editImageView;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            noteTitleTextView = itemView.findViewById(R.id.note_title_text_view);
            noteDescriptionTextView = itemView.findViewById(R.id.note_description_text_view);
            editImageView = itemView.findViewById(R.id.edit_image_view);

        }
    }

    @Override
    public int getItemCount() {
        return mNoteDataClassArrayList.size();
    }

}
