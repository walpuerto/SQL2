package com.example.sqlintegration_alpuerto;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NoteHandler extends DatabaseHelper {
    public  NoteHandler(Context context) {super(context);}

    //CRUD

    public  boolean create(Note note) {
        ContentValues values = new ContentValues();
        values.put("item", note.getItem());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        boolean isSuccessful = sqLiteDatabase.insert("Note", null, values) > 0;
        sqLiteDatabase.close();
        return isSuccessful;
    }
    public ArrayList<Note> readNotes() {
        ArrayList<Note> notes = new ArrayList<>();

        String sqlQuery = "SELECT * FROM Note ORDER by id ASC";

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sqlQuery, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                @SuppressLint("Range") String item = cursor.getString(cursor.getColumnIndex("item"));

                Note note = new Note(item);
                note.setId(id);
                notes.add(note);
            }
            while (cursor.moveToNext());

            cursor.close();
            sqLiteDatabase.close();
        }
        return  notes;
    }

    public  boolean update(Note note) {
        ContentValues values = new ContentValues();
        values.put("item", note.getItem());
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        boolean isSuccessful = sqLiteDatabase.update("Note", values, "id='"+note.getId()+"'", null) > 0;
        sqLiteDatabase.close();
        return isSuccessful;
    }

    public boolean delete(int id) {
        boolean isDeleted;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        isDeleted = sqLiteDatabase.delete("Note", "id='"+id+"'", null) > 0;
        sqLiteDatabase.close();
        return isDeleted;
    }
}
