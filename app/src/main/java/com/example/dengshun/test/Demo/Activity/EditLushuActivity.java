package com.example.dengshun.test.Demo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.dengshun.test.R;

public class EditLushuActivity extends Activity implements View.OnClickListener{

    private Button btnSaveTrack;
    private Button btnDeleteTrack;
    private ImageView imgBack;
    private RelativeLayout rlEditTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lushu);

        btnSaveTrack = (Button)findViewById(R.id.btn_save_track);
        btnDeleteTrack = (Button)findViewById(R.id.btn_delete_track);
        btnSaveTrack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(EditLushuActivity.this, LushuCommentActivity.class);
        startActivity(intent);
    }
}
