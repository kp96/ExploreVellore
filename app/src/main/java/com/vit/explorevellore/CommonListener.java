package com.vit.explorevellore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.Objects;

/**
 * Created by Krishna Kalubandi on 14-04-2015.
 */
public class CommonListener implements AdapterView.OnItemClickListener {
    Object[] names;
    Object[] locs;
    Object[] distance,fare,phone,hours;
    String caller;
    ActionBarActivity a;
    public CommonListener(String caller,Object[] names, Object[] locs, Object[] distance, Object[] fare, Object[] phone,
                          Object[] hours,ActionBarActivity a){
        this.caller = caller;
        this.names =  names;
        this.distance = distance;
        this.fare = fare;
        this.phone = phone;
        this.hours = hours;
        this.locs  = locs;
        this.a = a;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(a,CommonActivity.class);
        intent.putExtra("nameOfCaller",caller);
        intent.putExtra("name",(String)names[position]);
        intent.putExtra("loc",(String)locs[position]);
        intent.putExtra("distance",(String)distance[position]);
        intent.putExtra("fare",(String)fare[position]);
        if(phone != null)
            intent.putExtra("phone",(String)phone[position]);
        if(hours != null)
            intent.putExtra("hours",(String)hours[position]);

        a.startActivity(intent);
    }
}
