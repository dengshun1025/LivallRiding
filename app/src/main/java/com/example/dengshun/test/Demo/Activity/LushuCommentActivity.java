package com.example.dengshun.test.Demo.Activity;

import android.app.Activity;
import android.app.Dialog;
import android.icu.math.MathContext;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dengshun.test.R;

public class LushuCommentActivity extends Activity implements View.OnClickListener{

    private ImageView mImgBack;

    private TextView mTvSend;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_lushu_comment);

        mImgBack = (ImageView)findViewById(R.id.topbar_back_tc);
        mTvSend = (TextView)findViewById(R.id.top_bar_send_tv);

        mImgBack.setOnClickListener(this);
        mTvSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.topbar_back_tc:
                finish();
                break;
            case R.id.top_bar_send_tv:
                dialogShare();
                break;
            default:
                break;
        }
    }

    private void dialogShare(){
        dialog = new Dialog(LushuCommentActivity.this,R.style.dialog_style);
        View view = getLayoutInflater().inflate(R.layout.dialog_share,null);
        dialog.setContentView(view);
        final Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);  //此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.dialog_anim);  //添加动画
        WindowManager.LayoutParams wl = window.getAttributes();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.onWindowAttributesChanged(wl);
        view.findViewById(R.id.ll_share_track).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.ll_share_lushu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
