package com.example.sqlintegration_alpuerto;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    ArrayList<Note> notes;
    Context context;
    public  NoteAdapter(ArrayList<Note> arrayList, Context context) {
        notes = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public  NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        View view = LayoutInflater.from(context).inflate(R.layout.noteholder, parent, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteHolder holder, int position) {
        holder.item.setText(notes.get(position).getItem());
    }

    @Override
    public  int getItemCount() {return notes.size();}

    class  NoteHolder extends  RecyclerView.ViewHolder {
        TextView item;

        public  NoteHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.txt_item);
        }
    }
}
