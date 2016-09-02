package com.example.dengshun.test.Demo.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dengshun.test.R;
import com.example.dengshun.test.Demo.Fragment.ChallengeFragment;
import com.example.dengshun.test.Demo.Fragment.LaibaFragment;
import com.example.dengshun.test.Demo.Fragment.MessageFragment;
import com.example.dengshun.test.Demo.Fragment.MyFragment;
import com.example.dengshun.test.Demo.Fragment.RideFragment;

/**
 *  主要活动页面，下方是一个RadioGroup导航条，上方用来切换显示Fragment。
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private RelativeLayout rlChallenge;
    private RelativeLayout rlLaiba;
    private RelativeLayout rlRide;
    private RelativeLayout rlMessage;
    private RelativeLayout rlMy;
    private ImageView imgChallenge;
    private ImageView imgLaiba;
    private ImageView imgRide;
    private ImageView imgMessage;
    private ImageView imgMy;
    private TextView txtChallenge;
    private TextView txtLaiba;
    private TextView txtRide;
    private TextView txtMessage;
    private TextView txtMy;
    private MyFragment myFragment;
    private RideFragment rideFragment;
    private MessageFragment messageFragment;
    private LaibaFragment laibaFragment;
    private ChallengeFragment challengeFragment;
    private FragmentManager fragmentManger;
    private long exitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlChallenge = (RelativeLayout)findViewById(R.id.rl_challenge);
        rlLaiba = (RelativeLayout)findViewById(R.id.rl_laiba);
        rlRide = (RelativeLayout)findViewById(R.id.rl_ride);
        rlMessage = (RelativeLayout)findViewById(R.id.rl_message);
        rlMy = (RelativeLayout)findViewById(R.id.rl_my);
        imgChallenge = (ImageView)findViewById(R.id.img_challenge);
        imgLaiba = (ImageView)findViewById(R.id.img_laiba);
        imgRide = (ImageView)findViewById(R.id.img_ride);
        imgMessage = (ImageView)findViewById(R.id.img_message);
        imgMy = (ImageView)findViewById(R.id.img_my);
        txtChallenge = (TextView)findViewById(R.id.txt_challenge);
        txtLaiba = (TextView)findViewById(R.id.txt_laiba);
        txtMessage = (TextView)findViewById(R.id.txt_message);
        txtRide = (TextView)findViewById(R.id.txt_ride);
        txtMy = (TextView)findViewById(R.id.txt_my);
        rlMessage.setOnClickListener(this);
        rlLaiba.setOnClickListener(this);
        rlRide.setOnClickListener(this);
        rlChallenge.setOnClickListener(this);
        rlMy.setOnClickListener(this);
        fragmentManger = getSupportFragmentManager();

        initMyFragment();//初始化个人中心，登录后默认显示个人中心

    }

    /**
     *  导航条，点击切换Fragment
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_challenge:
                initChallengeFragment();
                break;
            case R.id.rl_laiba:
                initLaibaFragment();
                break;
            case R.id.rl_ride:
                initRideFragment();
                break;
            case R.id.rl_message:
                initMessageFragment();
                break;
            case R.id.rl_my:
                initMyFragment();
                break;
            default:
                break;
        }
    }

    //初始化Fragment
    private void initMyFragment(){
        imgRide.setSelected(false);
        imgLaiba.setSelected(false);
        imgChallenge.setSelected(false);
        imgMessage.setSelected(false);
        imgMy.setSelected(true);
        txtMessage.setSelected(false);
        txtLaiba.setSelected(false);
        txtRide.setVisibility(View.VISIBLE);
        txtChallenge.setSelected(false);
        txtMy.setSelected(true);
        FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
        if (myFragment == null){
            myFragment = new MyFragment();
        }
        fragmentTransaction.replace(R.id.main_fl_content,myFragment);
        fragmentTransaction.commit();
    }
    private void initMessageFragment(){
        imgRide.setSelected(false);
        imgLaiba.setSelected(false);
        imgChallenge.setSelected(false);
        imgMessage.setSelected(true);
        imgMy.setSelected(false);
        txtMessage.setSelected(true);
        txtLaiba.setSelected(false);
        txtRide.setVisibility(View.VISIBLE);
        txtChallenge.setSelected(false);
        txtMy.setSelected(false);
        FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
        if (messageFragment == null){
            messageFragment = new MessageFragment();
        }
        fragmentTransaction.replace(R.id.main_fl_content,messageFragment);
        fragmentTransaction.commit();
    }
    private void initRideFragment(){
        imgRide.setSelected(true);
        imgLaiba.setSelected(false);
        imgChallenge.setSelected(false);
        imgMessage.setSelected(false);
        imgMy.setSelected(false);
        txtMessage.setSelected(false);
        txtLaiba.setSelected(false);
        txtRide.setVisibility(View.GONE);
        txtChallenge.setSelected(false);
        txtMy.setSelected(false);
        FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
        if (rideFragment == null){
            rideFragment = new RideFragment();
        }
        fragmentTransaction.replace(R.id.main_fl_content,rideFragment);
        fragmentTransaction.commit();
    }
    private void initLaibaFragment(){
        imgRide.setSelected(false);
        imgLaiba.setSelected(true);
        imgChallenge.setSelected(false);
        imgMessage.setSelected(false);
        imgMy.setSelected(false);
        txtMessage.setSelected(false);
        txtLaiba.setSelected(true);
        txtRide.setVisibility(View.VISIBLE);
        txtChallenge.setSelected(false);
        txtMy.setSelected(false);
        FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
        if (laibaFragment == null){
            laibaFragment = new LaibaFragment();
        }
        fragmentTransaction.replace(R.id.main_fl_content,laibaFragment);
        fragmentTransaction.commit();
    }
    private void initChallengeFragment(){
        imgRide.setSelected(false);
        imgLaiba.setSelected(false);
        imgChallenge.setSelected(true);
        imgMessage.setSelected(false);
        imgMy.setSelected(false);
        txtMessage.setSelected(false);
        txtLaiba.setSelected(false);
        txtRide.setVisibility(View.VISIBLE);
        txtChallenge.setSelected(true);
        txtMy.setSelected(false);
        FragmentTransaction fragmentTransaction = fragmentManger.beginTransaction();
        if (challengeFragment == null){
            challengeFragment = new ChallengeFragment();
        }
        fragmentTransaction.replace(R.id.main_fl_content,challengeFragment);
        fragmentTransaction.commit();
    }

    //监听back键
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    //两秒内连续点击两次back键退出
    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
