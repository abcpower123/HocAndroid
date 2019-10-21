package com.aszqsc.friendsr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class UserDetail extends AppCompatActivity {
    User u;
    RatingBar rb;
    ImageView avatar;
    TextView name;
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_user_detail);

        rb=findViewById(R.id.ratingBar);
        avatar=findViewById(R.id.imgUserDetail);
        name=findViewById(R.id.txtUserNameDetail);
        desc=findViewById(R.id.txtDescriptionDetail);

        u= (User) this.getIntent().getSerializableExtra("User");

        rb.setRating(this.getIntent().getIntExtra("vote",0));
        if(u.getAva_name()==null||u.getName().isEmpty()){
            avatar.setImageResource(u.getAva_id());
        }else{
            //set image from uri
        }
        name.setText(u.getName());
        desc.setText(u.getDescription());

    }

    @Override
    public void onBackPressed() {
        Intent m=new Intent();
        int ratting= (int) rb.getRating();
        m.putExtra("voteresult",ratting);

        m.putExtra("userid",u.getId());
        m.putExtra("username",u.getName());
        setResult(RESULT_OK,m);

        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
