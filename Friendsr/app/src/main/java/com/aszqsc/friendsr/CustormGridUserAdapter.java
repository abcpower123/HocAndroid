package com.aszqsc.friendsr;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustormGridUserAdapter extends BaseAdapter {
    private List<User> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public CustormGridUserAdapter(List<User> listData, Context context) {
        this.listData = listData;
        this.context = context;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            view=layoutInflater.inflate(R.layout.grid_user_layout,null);
            holder=new ViewHolder();
            holder.Avatar=(ImageView) view.findViewById(R.id.gridava);
            holder.Name=(TextView) view.findViewById(R.id.gridtxtName);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        User u=this.listData.get(i);
        holder.Name.setText(u.getName());
        if(u.getAva_name()==null||u.getName().isEmpty()){
            holder.Avatar.setImageResource(u.getAva_id());
        }else{
            //set image from uri
        }
        return view;
    }
    static  class ViewHolder{
        ImageView Avatar;
        TextView Name;
    }
}
