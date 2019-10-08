package com.aszqsc.friendsr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public final String TAG = MainActivity.this.getClass().getName();
    public static final String FIRST_STAFF = "first_staff";
    public static final String SECOND_STAFF = "second_staff";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Employee> list=new ArrayList<>();
        Employee employee = new Employee(1, "Nguyen Viet Manh");
        Employee employee2 = new Employee(2, "Do Xuan Duc");
        list.add(employee);
        list.add(employee2);

        SharedPrefs.getInstance().put(FIRST_STAFF, employee);
        SharedPrefs.getInstance().put(SECOND_STAFF, employee2);
        SharedPrefs.getInstance().put("mylist", list);

//
//        Log.e(TAG, SharedPrefs.getInstance().get(FIRST_STAFF, Employee.class).toString());
//        Log.e(TAG, SharedPrefs.getInstance().get(SECOND_STAFF, Employee.class).toString());
        Type colectionType=new TypeToken<ArrayList<Employee>>(){}.getType();

        ArrayList<Employee> recive=App.self().getGSon().fromJson(SharedPrefs.getInstance().get("mylist",String.class),colectionType);
        Log.e(TAG, String.valueOf(recive.get(0).getName()));
    }
}
