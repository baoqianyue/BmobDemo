package com.barackbao.bmobtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

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

        //登录操作
        btnLoginIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if (!TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);

                    user.login(MainActivity.this, new SaveListener() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT)
                                    .show();
                        }

                        @Override
                        public void onFailure(int i, String s) {
                            Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    });
                }
            }
        });
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
    }
}
