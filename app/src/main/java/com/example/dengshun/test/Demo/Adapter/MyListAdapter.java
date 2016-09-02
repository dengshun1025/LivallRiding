package com.example.dengshun.test.Demo.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dengshun.test.R;

import java.util.List;

import static android.view.LayoutInflater.*;

/**
 *
 * Created by dengshun on 2016/7/22.
 *
 */
public class MyListAdapter extends ArrayAdapter<MyListItem> {

    private int resourceId;

    public MyListAdapter(Context context, int resourceId, List<MyListItem> myListItem){
        super(context,resourceId, myListItem);
        this.resourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        MyListItem items = getItem(position);
        View view = from(getContext()).inflate(resourceId,null);
        ImageView imgOne = (ImageView) view.findViewById(R.id.img_one_my);
        TextView txt = (TextView) view.findViewById(R.id.txt_my);
        ImageView imgTwo = (ImageView) view.findViewById(R.id.img_two_my);
        imgOne.setImageResource(items.getImgOneId());
        txt.setText(items.getTxt());
        imgTwo.setImageResource(items.getImgTwoId());
        return view;
    }
}
