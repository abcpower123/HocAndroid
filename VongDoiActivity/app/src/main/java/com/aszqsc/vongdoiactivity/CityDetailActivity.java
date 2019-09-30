package com.aszqsc.vongdoiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CityDetailActivity extends AppCompatActivity {
    private String TAG = "CityDetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);
        Intent intent = getIntent();
        String cityStr = intent.getStringExtra("name");
        TextView cityNameTV = findViewById(R.id.cityName);
        TextView cityDescTV = findViewById(R.id.cityDescription);
        cityNameTV.setText(cityStr);
        cityDescTV.setText(cityStr+" is a very beautiful city in Viet Nam");
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
