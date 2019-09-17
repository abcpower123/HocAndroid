package com.aszqsc.layoutandwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LearnListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_list_view);

        List<Element> eles=getList();
        final ListView lstview=findViewById(R.id.lstview);
        lstview.setAdapter(new EleCustomListAdapter(eles,this));
        final TextView title= findViewById(R.id.textView4);
        lstview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Element e= (Element) lstview.getItemAtPosition(i);
                Toast.makeText(LearnListView.this, "You choose "+e.getElename(),Toast.LENGTH_SHORT).show();
                title.setText(e.getElename());
                title.setTextColor(EleCustomListAdapter.getColorCode(e.getColor()));
            }
        });
    }

    private List<Element> getList() {
        List<Element> eles= new ArrayList<>();
        eles.add(new Element("Fire","Burn everything",R.drawable.fire,"fire"));
        eles.add(new Element("Lighting","Struck everything",R.drawable.lighting,"lighting"));
        eles.add(new Element("Wind","Power of air",R.drawable.wind,"wind"));
        eles.add(new Element("Water","A start of life",R.drawable.water, "water"));
        eles.add(new Element("Force","Push or pull things",R.drawable.force, "force"));
        eles.add(new Element("Earth","Where to live",R.drawable.earth, "earth"));
        eles.add(new Element("Light","To see everything",R.drawable.light, "light"));
        eles.add(new Element("Ice","Very cold ",R.drawable.ice,"ice"));
        eles.add(new Element("Darkness","Not see anything",R.drawable.darkness,"dark"));
        eles.add(new Element("Sound","Power of vibration",R.drawable.sound,"sound"));

        return eles;
    }

}
