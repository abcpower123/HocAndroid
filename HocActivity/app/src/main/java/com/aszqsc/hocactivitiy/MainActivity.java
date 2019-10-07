package com.aszqsc.hocactivitiy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    //code for recoginze activity for result
    final int USERDETAIL= 1;
    final int CAPTURE= 2;
    final int REQUEST_ID_READ_WRITE_PERMISSION=3;
    ScrollView scrollview;
    EditText txtUserName;
    EditText txtPassword;
    TextView txtEmail;
    ImageView imgAva;
    Uri uri;
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
////code for non saving
//            Bitmap bp= (Bitmap) data.getExtras().get("data");
//            imgAva.setImageBitmap(bp);
            Log.d("Saved to: ",""+uri);
            imgAva.setImageURI(uri);
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
        //2 lines for getting uri from external storage
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        Log.d("Begin","take photo");
        if (android.os.Build.VERSION.SDK_INT >= 23) { //permission
            // Kiểm tra quyền đọc/ghi dữ liệu vào thiết bị lưu trữ ngoài.
            int readPermission = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE);
            int writePermission = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (writePermission != PackageManager.PERMISSION_GRANTED ||
                    readPermission != PackageManager.PERMISSION_GRANTED) {

                // Nếu không có quyền, cần nhắc người dùng cho phép.
                this.requestPermissions(
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_ID_READ_WRITE_PERMISSION
                );
                return;
            }
        }


            Log.d("Start","take photo");
            takePhoToF();


    }

    private void takePhoToF() {
        File dir= Environment.getExternalStorageDirectory();
        if(!dir.exists()){
            dir.mkdir();
        }
        String savePath=dir.getAbsolutePath()+"/myImageCapture.jpg";
        File imageCapture=new File(savePath);
        Log.d("Capture location:",savePath);
         uri=Uri.fromFile(imageCapture);
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        this.startActivityForResult(intent,CAPTURE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_ID_READ_WRITE_PERMISSION:{
                if(grantResults.length>1&&grantResults[0]==PackageManager.PERMISSION_GRANTED &&grantResults[1]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "Permission granted!", Toast.LENGTH_LONG).show();
                    takePhoToF();
                }
                else{
                    Toast.makeText(this, "Permission denied!", Toast.LENGTH_LONG).show();
                }

                break;
            }
        }
    }
}
