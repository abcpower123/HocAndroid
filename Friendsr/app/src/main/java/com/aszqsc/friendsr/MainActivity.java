package com.aszqsc.friendsr;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    public final String TAG = MainActivity.this.getClass().getName();
    public static final String FIRST_STAFF = "first_staff";
    public static final String SECOND_STAFF = "second_staff";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleImageView cv=findViewById(R.id.profile_image);

        ArrayList<Employee> list=new ArrayList<>();
        Employee employee = new Employee(1, "Nguyen Viet Manh");
        Employee employee2 = new Employee(2, "Do Xuan Duc");
        list.add(employee);
        list.add(employee2);


        cv.setImageResource(R.drawable.nobita);
        SharedPrefs.getInstance().put("mylist", list);

//
//        Log.e(TAG, SharedPrefs.getInstance().get(FIRST_STAFF, Employee.class).toString());
//        Log.e(TAG, SharedPrefs.getInstance().get(SECOND_STAFF, Employee.class).toString());
        Type colectionType=new TypeToken<ArrayList<Employee>>(){}.getType();

        ArrayList<Employee> recive=App.self().getGSon().fromJson(SharedPrefs.getInstance().get("mylist",String.class),colectionType);
        Log.e(TAG, String.valueOf(recive.get(0).getName()));
    }
}
