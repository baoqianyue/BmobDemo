package com.barackbao.bmobtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLoginIn;
    private Button btnLoginUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bmob初始化
        Bmob.initialize(this, "fe1ca7bff87c7ced0e5319e257917c1a");
        initViews();

    }

    private void initViews() {
        edtUsername = (EditText) findViewById(R.id.activity_home_username_edt);
        edtPassword = (EditText) findViewById(R.id.activity_home_password_edt);
        btnLoginIn = (Button) findViewById(R.id.activity_home_login_in_btn);
        btnLoginUp = (Button) findViewById(R.id.activity_home_login_up_btn);

        onClick();
    }

    private void onClick() {
        //跳转到注册页面
        btnLoginUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginUpActivity.class);
                startActivity(intent);
            }
        });
        //登录操作
        btnLoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
