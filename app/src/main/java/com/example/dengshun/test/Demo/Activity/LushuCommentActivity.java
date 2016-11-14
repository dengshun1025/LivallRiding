package com.example.dengshun.test.Demo.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dengshun.test.R;

public class LushuCommentActivity extends Activity implements View.OnClickListener{

    private ImageView imgBack;
    private TextView txtSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_lushu_comment);

        imgBack = (ImageView)findViewById(R.id.topbar_back_tc);
        imgBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
