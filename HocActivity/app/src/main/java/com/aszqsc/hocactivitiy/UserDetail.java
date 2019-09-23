package com.aszqsc.hocactivitiy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserDetail extends AppCompatActivity {
    TextView hello;
    EditText emailUser;
    boolean ok=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        hello=findViewById(R.id.textView);
        emailUser=findViewById(R.id.txtUserEmail);
        hello.setText("Hello "+this.getIntent().getStringExtra("username"));
    }

    public void Backbtn(View view) {
        ok=true;
        this.onBackPressed();
    }



    @Override
    public void finish() {
        if(ok) {
            Intent data = new Intent();
            data.putExtra("email", emailUser.getText().toString());
            this.setResult(Activity.RESULT_OK, data);
        }
        else this.setResult(RESULT_CANCELED);
        super.finish();
    }
}
