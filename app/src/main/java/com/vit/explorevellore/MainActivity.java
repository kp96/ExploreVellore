package com.vit.explorevellore;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {
    ArrayAdapter maArrayAdapter;
    String[] listOfAttractions;
    ListView lvMain;
    private static final String MY_PREFS = "MY_PREFS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences settings = getSharedPreferences(MY_PREFS,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("isFirst",true);
        editor.commit();
        listOfAttractions = getResources().getStringArray(R.array.listOfAttractions);
        maArrayAdapter = new ArrayAdapter(this,R.layout.list_item,listOfAttractions);
        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(maArrayAdapter);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,Attractions.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, Dining.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,Accommodation.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this,Shopping.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this,Theatres.class));
                        break;

                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
