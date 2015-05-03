package com.vit.explorevellore;

import android.app.ActionBar;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Krishna Kalubandi on 13-04-2015.
 */
public class Attractions extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attractions_layout);
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<String> addr = new ArrayList<String>();
        ArrayList<String> distance = new ArrayList<String>();
        ArrayList<String> fare = new ArrayList<String>();
        Database dbHelper = new Database(this);
        SQLiteDatabase myDatabase = dbHelper.getReadableDatabase();
        Cursor res = myDatabase.rawQuery("select * from attractions",null);
        res.moveToFirst();
        while(res.isAfterLast() == false) {
            items.add(res.getString(res.getColumnIndex("name")));
            addr.add(res.getString(res.getColumnIndex("location")));
            distance.add(res.getString(res.getColumnIndex("distance")));
            fare.add(res.getString(res.getColumnIndex("fare")));
            res.moveToNext();
        }
        ArrayAdapter mArrayAdapter = new ArrayAdapter(this,R.layout.list_item,items);
        ListView lvAttractions = (ListView) findViewById(R.id.lvAttractions);
        lvAttractions.setAdapter(mArrayAdapter);
        lvAttractions.setOnItemClickListener(new CommonListener("Attractions",items.toArray(),addr.toArray(),
                distance.toArray(),fare.toArray(),null,null,this));
    }
}
