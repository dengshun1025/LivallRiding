package com.example.dengshun.test.Demo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.dengshun.test.Demo.Activity.LoginActivity;
import com.example.dengshun.test.R;

import java.util.ArrayList;
import java.util.List;

import com.example.dengshun.test.Demo.Adapter.MyListAdapter;
import com.example.dengshun.test.Demo.Adapter.MyListItem;

/**
 *   个人中心。
 */

public class MyFragment extends Fragment{

    private Button btnMyLogin; //个人中心的登录按钮
    private List<MyListItem> myList = new ArrayList<>();

    public MyFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        myList.clear();
        initListView();
        MyListAdapter adapter = new MyListAdapter(getActivity(),R.layout.item_my_listview,myList);
        ListView listView = (ListView)getActivity().findViewById(R.id.my_listView);
        listView.setAdapter(adapter);
        //为个人中心的登录按钮添加点击事件
        btnMyLogin = (Button)getActivity().findViewById(R.id.btn_my_login);
        btnMyLogin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getBaseContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initListView(){
        MyListItem mall = new MyListItem(R.mipmap.lmp_home_mall_img,"商城",R.mipmap.my_fragment_ride_record_img);
        myList.add(mall);
        MyListItem emergencyContact = new MyListItem(R.mipmap.lmp_home_emer_img,"紧急联系人",R.mipmap.my_fragment_ride_record_img);
        myList.add(emergencyContact);
        MyListItem offlineMap = new MyListItem(R.mipmap.lmp_home_offline_map_img,"离线地图",R.mipmap.my_fragment_ride_record_img);
        myList.add(offlineMap);
    }
}
