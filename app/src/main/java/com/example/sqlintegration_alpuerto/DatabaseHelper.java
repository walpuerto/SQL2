package com.example.sqlintegration_alpuerto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private  static  final  int DATABASE_VERSION = 1;
    private  static  final  String DATABASE_NAME = "NotesDatabase";

    public  DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE Note(id INTEGER PRIMARY KEY AUTOINCREMENT, item TEXT)";
        db.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlQuery = "DROP TABLE IF EXISTS Note";
        db.execSQL(sqlQuery);
        onCreate(db);
    }
}
