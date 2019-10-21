package com.aszqsc.friendsr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListFriend extends AppCompatActivity {
    final int USER_DETAIL_CODE=1;
    User currentUser=null;
    List<User> listUsers=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_list_friend);
        //load current and list user
        Type colectionTypeLISTUSER=new TypeToken<List<User>>(){}.getType();
        listUsers=App.self().getGSon().fromJson(SharedPrefs.getInstance().get("mylistuser",String.class),colectionTypeLISTUSER);
        Type colectionTypeCURRENTUSER=new TypeToken<User>(){}.getType();
        currentUser=App.self().getGSon().fromJson(SharedPrefs.getInstance().get("mycurrentuser",String.class),colectionTypeCURRENTUSER);
        if(currentUser==null){
            Log.d("Load","current user null");
            currentUser=new User();

        }

        if(listUsers==null){
            Log.d("Load","listuser null");
            listUsers=CreateList();
        }

        Log.d("Current user id: ",SharedPrefs.getInstance().get("mycurrentuser",String.class));
        final ExpandableHeightGridView gridUser= findViewById(R.id.gridUser);
        gridUser.setAdapter(new CustormGridUserAdapter(listUsers,this));
        gridUser.setExpanded(true);
        gridUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User u= (User) gridUser.getItemAtPosition(i);
                Toast.makeText(ListFriend.this,"Choose "  +u.getName(), Toast.LENGTH_SHORT).show();
                Intent t=new Intent(ListFriend.this, UserDetail.class);
                t.putExtra("User",u);
                t.putExtra("vote",findVote(u));
                ListFriend.this.startActivityForResult(t,USER_DETAIL_CODE);

            }
        });
    }

    private int findVote(User u) {

        for (VoteUser uservote: currentUser.getListVote()) {

            if(uservote.getUserid()==u.getId()){

                return uservote.getVote();
            }
        }
        currentUser.getListVote().add(new VoteUser(u.getId(),0));
        return 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == USER_DETAIL_CODE && resultCode == RESULT_OK) {
            int vote=data.getIntExtra("voteresult",0);
            int userid=data.getIntExtra("userid",-1);


            for (VoteUser uservote: currentUser.getListVote()) {
                if(uservote.getUserid()==userid){
                  uservote.setVote(vote);
                  saveALL();
                    Toast.makeText(this, "You vote "+data.getStringExtra("username")+" "+vote+" stars", Toast.LENGTH_SHORT).show();
                   break;
                }

            }

        } else Toast.makeText(this, "Cancel!", Toast.LENGTH_SHORT).show();
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void saveALL() {
        SharedPrefs.getInstance().put("mylistuser", listUsers);
        SharedPrefs.getInstance().put("mycurrentuser", currentUser);
    }

    private List<User> CreateList() {
        ArrayList<User> list=new ArrayList<>();
        list.add(new User(1,"Doraemon",6,true,R.drawable.doremon,"Tôi là 1 chú mèo máy"));
        list.add(new User(2,"Nobita",13,true,R.drawable.nobita,"Tôi là học sinh lớp 6 hậu đậu"));
        list.add(new User(3,"Xuka",6,true,R.drawable.xuka,"Tôi thích tắm và chơi violin"));
        list.add(new User(4,"Chaien",6,true,R.drawable.chaien,"Tôi to khỏe và thích hát"));
        list.add(new User(5,"Dekhi",6,true,R.drawable.dekhi,"Tôi thông minh và tốt bụng"));
        list.add(new User(6,"Xeko",6,true,R.drawable.xeko,"Tôi giàu có và dẻo miệng"));
        list.add(new User(7,"Doremi",6,true,R.drawable.doremi,"Tôi tốt bụng và dễ thương"));


        return list;
    }
}
