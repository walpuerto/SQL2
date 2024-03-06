package com.example.sqlintegration_alpuerto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton;
    ArrayList notes;
    RecyclerView recyclerView;
    NoteAdapter NoteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(v -> {
            LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewInput = inflater.inflate(R.layout.note_input, null, false);
            EditText editItem = viewInput.findViewById(R.id.edit_item);
            
            new AlertDialog.Builder(MainActivity.this)
                    .setView(viewInput)
                    .setTitle("Add Items")
                    .setPositiveButton("Add", (dialog, which) -> {
                        String title = editItem.getText().toString();

                        Note note = new Note(title);
                        boolean isInserted = new NoteHandler(MainActivity.this).create(note);

                        if (isInserted) {
                            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show();
                            loadNotes();
                        } else {
                            Toast.makeText(this, "WALA NA SAVE", Toast.LENGTH_SHORT).show();
                        }

                        dialog.cancel();
                    }).show();
        });
    }
}