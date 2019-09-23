package com.aszqsc.hocactivitiy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //code for recoginze activity for result
    final int USERDETAIL= 1;
    final int CAPTURE= 2;
    ScrollView scrollview;
    EditText txtUserName;
    EditText txtPassword;
    TextView txtEmail;
    ImageView imgAva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollview =findViewById(R.id.detailContainer);
        scrollview.setVisibility(View.INVISIBLE);
        txtUserName=findViewById(R.id.txtUserLogin);
        txtPassword=findViewById(R.id.txtUserEmail);
        txtEmail=findViewById(R.id.txtEmail);
        imgAva=findViewById(R.id.imgAvatar);
    }

    public void login(View view) {
        String username=txtUserName.getText().toString();
        String password=txtPassword.getText().toString();
        if(new CheckLogin().check(username,password)) {
            Intent t = new Intent(this, UserDetail.class);
            t.putExtra("username",username);
            t.putExtra("passoword",password);
            startActivityForResult(t,USERDETAIL);
        }
        else Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode== Activity.RESULT_OK&&requestCode==USERDETAIL){
            scrollview.setVisibility(View.VISIBLE);
            txtEmail.setText(data.getStringExtra("email"));
        }else
        if(resultCode==Activity.RESULT_OK&&requestCode==CAPTURE){
            Bitmap bp= (Bitmap) data.getExtras().get("data");
            imgAva.setImageBitmap(bp);
        }else
            Toast.makeText(this,"Cancel!",Toast.LENGTH_SHORT).show();
    }

    public void SendEmail(View view) {
        String [] reciptions=new String[]{"aszqsc@gmail.com","aszqsc1998@gmail.com"};
        String subject="Test email send";
        String content="Email send from android";
        Intent sendE=new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
    sendE.putExtra(Intent.EXTRA_EMAIL,reciptions);
    sendE.putExtra(Intent.EXTRA_SUBJECT,subject);
    sendE.putExtra(Intent.EXTRA_TEXT,content);
    sendE.setType("text/plain");
    startActivity(Intent.createChooser(sendE,"Choose an email app"));
    }

    public void TakePhoto(View view) {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.startActivityForResult(intent,CAPTURE);
    }
}
