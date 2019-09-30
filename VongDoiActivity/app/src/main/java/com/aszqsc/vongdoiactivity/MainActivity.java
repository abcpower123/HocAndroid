package com.aszqsc.vongdoiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> cities;
    private String TAG="MainActivity";
    ListView cityLV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cities = new ArrayList<String>();
        cities.add("Da Nang");
        cities.add("Ho Chi Minh");
        cities.add("Hai Phong");
        cities.add("Qui Nhon");
        cities.add("Can Tho");
        cityLV = findViewById(R.id.cityListView);
        ArrayAdapter cityAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,cities);
        cityLV.setAdapter(cityAdapter);
        cityLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String city = cities.get(i);
                Intent cityIntent = new Intent(MainActivity.this,CityDetailActivity.class);
                cityIntent.putExtra("name",city);
                startActivity( cityIntent);

            }
        });
        Log.d(TAG,"==On Create called==");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"==OnStart Called==");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"==OnResume Called==");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"==OnStop Called==");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"==OnDestroy Called==");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"==OnRestart Called==");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"==OnPause Called==");
    }

}
