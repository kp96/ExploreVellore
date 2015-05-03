package com.vit.explorevellore;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Krishna Kalubandi on 13-04-2015.
 */
public class Shopping extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_layout);
        ArrayList<String> items = new ArrayList<String>();
        ArrayList<String> addr = new ArrayList<String>();
        ArrayList<String> distance = new ArrayList<String>();
        ArrayList<String> fare = new ArrayList<String>();
        ArrayList<String> phone = new ArrayList<String>();
        ArrayList<String> hours = new ArrayList<String>();
        Database dbHelper = new Database(this);
        SQLiteDatabase myDatabase = dbHelper.getReadableDatabase();
        Cursor res = myDatabase.rawQuery("select * from shopping",null);
        res.moveToFirst();
        int count = 0;
        while(count != 9){
            Log.d("Shopping.java",res.getString(res.getColumnIndex("name")));
            items.add(res.getString(res.getColumnIndex("name")));
            addr.add(res.getString(res.getColumnIndex("location")));
            distance.add(res.getString(res.getColumnIndex("distance")));
            fare.add(res.getString(res.getColumnIndex("fare")));
            phone.add(res.getString(res.getColumnIndex("phone")));
            hours.add(res.getString(res.getColumnIndex("hours")));
            ++count;
            res.moveToNext();
        }
        ArrayAdapter mArrayAdapter = new ArrayAdapter(this,R.layout.list_item,items);
        ListView lvShopping = (ListView) findViewById(R.id.lvShopping);
        lvShopping.setAdapter(mArrayAdapter);
        lvShopping.setOnItemClickListener(new CommonListener("Shopping",items.toArray(),addr.toArray(),
                distance.toArray(),fare.toArray(),phone.toArray(),hours.toArray(),this));
    }
}
