package com.aszqsc.hellowolrd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void getNewNum(Button pleft, Button pright){
        pleft.setText(String.valueOf(new Random().nextInt(100)));
        pright.setText(String.valueOf(new Random().nextInt(100)));
    }
    public void clickhandler(View view) {
        Button pleft=findViewById(R.id.btnleft);
        Button pright=findViewById(R.id.btnright);
        int a=Integer.parseInt(pleft.getText().toString());
        int b=Integer.parseInt(pright.getText().toString());

        if((view.getId()==pleft.getId()&&a>b)||(view.getId()==pright.getId()&&a<=b)){
            Toast.makeText(this,"Right",Toast.LENGTH_SHORT).show();
            score++;
        }
        else{
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show();
            score--;
        }
        TextView point= findViewById(R.id.tvscore);
        point.setText("Your score: "+ String.valueOf(score));
        getNewNum(pleft,pright);
    }
}
