package com.aszqsc.layoutandwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EleCustomListAdapter extends BaseAdapter {
    private List<Element> lstData;
    private LayoutInflater layoutInflater;
    private Context context;

    public EleCustomListAdapter(List<Element> lstData, Context context) {
        this.lstData = lstData;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return lstData.size();
    }

    @Override
    public Object getItem(int i) {
        return lstData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view==null){
            view=layoutInflater.inflate(R.layout.lstitemlayout,null);
            viewHolder=new ViewHolder();
            viewHolder.img=(ImageView) view.findViewById(R.id.imgEle);
            viewHolder.name=(TextView) view.findViewById(R.id.txtEleName);
            viewHolder.Description=(TextView) view.findViewById(R.id.txtEleDesc);
            view.setTag(viewHolder);
        }
        else{
            viewHolder= (ViewHolder) view.getTag();
        }
        Element ele=this.lstData.get(i);
        viewHolder.name.setText(ele.getElename());
        viewHolder.Description.setText(ele.getDescription());
        viewHolder.name.setTextColor(this.getColorCode(ele.getColor()));
        viewHolder.Description.setTextColor(this.getColorCode(ele.getColor()));
        viewHolder.img.setImageDrawable(context.getResources().getDrawable(ele.getImgName()));
        return view;
    }

    public static int getColorCode(String namecolor){
        switch (namecolor){
            case "fire":
                return Color.parseColor("#EC0000");
            case "lighting":
                return Color.parseColor("#A5A800");
            case "wind":
                return Color.parseColor("#03F003");
            case "water":
                return Color.parseColor("#009BF8");
            case "force":
                return Color.parseColor("#ED01DB");
            case "earth":
                return Color.parseColor("#E88F02");
            case "light":
                return Color.parseColor("#E0DB40");
            case "ice":
                return Color.parseColor("#50E0F5");
            case "dark":
                return Color.parseColor("#9903CB");
            case "sound":
                return Color.parseColor("#6C6C6C");

            default:return Color.parseColor("#6C6C6C");
        }
    }
    class ViewHolder{
        ImageView img;
        TextView name;
        TextView Description;

    }
}
