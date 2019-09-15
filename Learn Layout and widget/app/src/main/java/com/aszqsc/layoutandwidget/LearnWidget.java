package com.aszqsc.layoutandwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class LearnWidget extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    boolean check=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_widget);

        initSpinner();

    }
    void initSpinner(){

        Spinner dropdown=findViewById(R.id.spinner);
        String []items =new String[] {"1","2","3"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

            dropdown.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView t=findViewById(R.id.txtT);
        ImageView m=findViewById(R.id.imgview);

        m.setImageDrawable(getResources().getDrawable(R.drawable.dhsp));
        switch (i){
            case 0: t.setText("This is picture 1"); m.setImageDrawable(getResources().getDrawable(R.drawable.phone)); break;
            case 1:t.setText("This is picture 2");  m.setImageDrawable(getResources().getDrawable(R.drawable.dhsp)); break;
            default:t.setText("This is picture 3");  m.setImageDrawable(getResources().getDrawable(R.drawable.address)); break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void Switchcl(View view) {
        if(check) {
            ImageView m = findViewById(R.id.imgview);
            m.setVisibility(View.INVISIBLE);
        }
        else{
            ImageView m = findViewById(R.id.imgview);
            m.setVisibility(View.VISIBLE);
        }
        check=!check;
    }
}
