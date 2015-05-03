package com.vit.explorevellore;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Krishna Kalubandi on 13-04-2015.
 */
public class Accommodation extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accommodation_layout);
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<String> addr = new ArrayList<String>();
        ArrayList<String> distance = new ArrayList<String>();
        ArrayList<String> fare = new ArrayList<String>();
        ArrayList<String> phone = new ArrayList<String>();
        Database dbHelper = new Database(this);
        SQLiteDatabase myDatabase = dbHelper.getReadableDatabase();
        Cursor res = myDatabase.rawQuery("select * from accommodation",null);
        res.moveToFirst();
        while(res.isAfterLast() == false){
            items.add(res.getString(res.getColumnIndex("name")));
            addr.add(res.getString(res.getColumnIndex("location")));
            distance.add(res.getString(res.getColumnIndex("distance")));
            fare.add(res.getString(res.getColumnIndex("fare")));
            phone.add(res.getString(res.getColumnIndex("phone")));
            res.moveToNext();
        }
        ArrayAdapter mArrayAdapter = new ArrayAdapter(this,R.layout.list_item,items);
        ListView lvAccommodation = (ListView) findViewById(R.id.lvAccommodation);
        lvAccommodation.setAdapter(mArrayAdapter);

        lvAccommodation.setOnItemClickListener(new CommonListener("Accommodation",items.toArray(),addr.toArray(),distance.toArray()
        ,fare.toArray(),phone.toArray(),null,this));
    }
}
