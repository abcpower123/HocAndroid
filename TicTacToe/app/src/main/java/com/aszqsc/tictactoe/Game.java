package com.aszqsc.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.logging.Logger;

public class Game extends AppCompatActivity {
    //game vars
    private int gameMatrix[]=null;
    GridLayout g;
    int count=0;
    private boolean player=false;
    //activity vars
    TextView title;
    Button playAgain;
    Drawable d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_game);
        playAgain=findViewById(R.id.btnPlayAgain);
        title=findViewById(R.id.txtTitle);
        //init varible
        if (gameMatrix==null) gameMatrix=new int[9];

        //init event
        g= findViewById(R.id.gridLayout);
        d=g.getChildAt(0).getBackground();
        for(int i=0;i<g.getChildCount();i++){
            final ImageButton im= (ImageButton) g.getChildAt(i);
            final int finalI = i;
            im.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Btn", String.valueOf(finalI));
                    //mode play
                    if(player){
                        gameMatrix[finalI]=1;
                        im.setImageDrawable(getResources().getDrawable(R.drawable.sun));
                    }
                    else {
                        gameMatrix[finalI]=2;
                        im.setImageDrawable(getResources().getDrawable(R.drawable.night));
                    }
                    count++;
                    player=!player;//change player
                    //disable btn
                    view.setEnabled(false);
                    checkWin(finalI);
                }
            });
        }
    }

    private void checkWin(int i) {
        if (    check(i,0,1,2)||
                check(i,2,5,8)||
                check(i,6,7,8)||
                check(i,0,3,6)||
                check(i,0,4,8)||
                check(i,2,4,6)||
                check(i,3,4,5)||
                check(i,1,4,7)
        ){
            if(gameMatrix[i]==1) title.setText("The sun has won!");
            else title.setText("The moon has won!");
        }else if(count>=9) title.setText("No one win!");
                else return;
        for(int a=0;a<g.getChildCount();a++){
            g.getChildAt(a).setEnabled(false);
        }
        playAgain.setVisibility(View.VISIBLE);
    }

    private boolean check(int i, int i1, int i2, int i3) {
        boolean result=gameMatrix[i]==gameMatrix[i1]&&gameMatrix[i]==gameMatrix[i2]&&gameMatrix[i]==gameMatrix[i3];
        if(result){
            g.getChildAt(i1).setBackgroundColor(Color.RED);
            g.getChildAt(i2).setBackgroundColor(Color.RED);
            g.getChildAt(i3).setBackgroundColor(Color.RED);
//            g.getChildAt(i1).setBackground(getResources().getDrawable(android.R.drawable.btn_default));
//            g.getChildAt(i2).setBackground(getResources().getDrawable(android.R.drawable.btn_default));
//            g.getChildAt(i3).setBackground(getResources().getDrawable(android.R.drawable.btn_default));

        }
        return result;
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void playGameAgain(View view) {
        view.setVisibility(View.INVISIBLE);
        for (int i=0;i<g.getChildCount();i++){
            gameMatrix[i]=0;
            ImageView iv= (ImageView) g.getChildAt(i);
            iv.setEnabled(true);
           iv.setBackground(d);
            title.setText("Tic Tac Toe");
            iv.setImageDrawable(null);
            count=0;
            player=false;
        }
    }
}
