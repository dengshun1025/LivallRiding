package com.example.dengshun.test.Demo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dengshun.test.R;
import com.example.dengshun.test.Demo.SQLite.SQLiteHelper;

/**
 *  登录界面
 */

public class LoginActivity extends Activity implements View.OnClickListener {

    private EditText mUser;
    private EditText mPwd;
    private Cursor mCursor;
    private String mUserName;
    private String mPassWord;
    private SQLiteHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Button btnExit;
    private Button btnLogin;
    private TextView txtEmail;
    private TableRow tableRowOne;
    private TableRow tableRowTwo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnExit = (Button) findViewById(R.id.btn_exit);
        btnLogin = (Button) findViewById(R.id.btn_login);
        mUser = (EditText)findViewById(R.id.edit_user);
        mPwd = (EditText)findViewById(R.id.edit_pwd);
        txtEmail = (TextView)findViewById(R.id.txt_email);
        tableRowOne = (TableRow)findViewById(R.id.tableRow_one);
        tableRowTwo = (TableRow)findViewById(R.id.tableRow_Two);
        databaseHelper = new SQLiteHelper(this, "users.db", null, 1);
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        btnExit.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        txtEmail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_exit:
                finish();
                break;
            case R.id.btn_login:
                mUserName = mUser.getText().toString().trim();
                mPassWord = mPwd.getText().toString().trim();
                mCursor = sqLiteDatabase.query("users",null,"username=? and password=?",new String[]{mUserName, mPassWord},null,null,null);
                if (mCursor !=null&& mCursor.getCount()>0) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"用户名或密码错误！",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.txt_email:
                if(txtEmail.getText().toString().equals("邮箱登录")) {
                    tableRowOne.setVisibility(View.GONE);
                    tableRowTwo.setVisibility(View.GONE);
                    txtEmail.setText("手机登录");
                }else{
                    tableRowOne.setVisibility(View.VISIBLE);
                    tableRowTwo.setVisibility(View.VISIBLE);
                    txtEmail.setText("邮箱登录");
                }
            default:
                break;
        }
    }
}
