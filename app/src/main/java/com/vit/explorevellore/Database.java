package com.vit.explorevellore;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Krishna Kalubandi on 13-04-2015.
 */
public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "explorevellore";
    private static final String[] TABLE_NAMES = {"attractions","dining","accommodation","shopping","theatres"};
    SharedPreferences settings;
    Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        settings = context.getSharedPreferences("MY_PREFS",0);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String tname : TABLE_NAMES) {
            String query = "CREATE TABLE " + tname +
                    "(name TEXT PRIMARY KEY, location TEXT, distance TEXT, fare TEXT, phone TEXT, hours TEXT );";
            db.execSQL(query);
        }
        if (settings.getBoolean("isFirst", false)) {
            new DatabaseWriter(db).write();
            settings.edit().putBoolean("isFirst", false).commit();
            Log.d("Database","Written");
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }
}
