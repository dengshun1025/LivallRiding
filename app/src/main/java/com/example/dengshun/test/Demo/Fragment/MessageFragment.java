package com.example.dengshun.test.Demo.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.example.dengshun.test.R;
import java.util.ArrayList;
import java.util.List;
import com.example.dengshun.test.Demo.Adapter.MyListAdapter;
import com.example.dengshun.test.Demo.Adapter.MyListItem;

/**
 *  消息页面。
 */
public class MessageFragment extends Fragment {

    private Button btnAddFriend;
    private PopupWindow popupWindow;
    private List<MyListItem> myList = new ArrayList<>();

    public MessageFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //listview设置
        myList.clear();
        initListView();
        MyListAdapter adapter = new MyListAdapter(getActivity(),R.layout.item_my_listview,myList);
        ListView listView = (ListView)getActivity().findViewById(R.id.message_listView);
        listView.setAdapter(adapter);
        //为消息页面的加号菜单添加点击事件
        btnAddFriend = (Button)getActivity().findViewById(R.id.btn_add_friend);
        btnAddFriend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View messageMenuView = getActivity().getLayoutInflater().inflate(R.layout.menu_message,null,false);
                popupWindow = new PopupWindow(messageMenuView, WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,true);
                popupWindow.setAnimationStyle(R.style.AppTheme);
                //菜单出现的位置设定
                popupWindow.showAsDropDown(btnAddFriend,0,50);
                messageMenuView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        // TODO Auto-generated method stub
                        if (popupWindow != null && popupWindow.isShowing()) {
                            popupWindow.dismiss();
                            popupWindow = null;
                        }
                        return false;
                    }
                });
            }
        });
    }

    //初始化ListView
    private void initListView(){
        MyListItem mall = new MyListItem(R.mipmap.llp_qq_btn,"验证消息",0);
        myList.add(mall);
        MyListItem emergencyContact = new MyListItem(R.mipmap.llp_wechat_btn,"我的好友",0);
        myList.add(emergencyContact);
        MyListItem offlineMap = new MyListItem(R.mipmap.llp_sina_btn,"我的群组",0);
        myList.add(offlineMap);
    }

}
