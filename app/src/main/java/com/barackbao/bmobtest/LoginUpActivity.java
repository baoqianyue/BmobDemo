package com.barackbao.bmobtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by BarackBao on 2017/5/13.
 */

public class LoginUpActivity extends AppCompatActivity {
    private EditText edtUsername;
    private EditText edtPassword;
    private EditText edtPasswordAgain;
    private EditText edtEmail;
    private Button btnLoginUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_up);

        initViews();

        //实现注册的功能
    }


    private void initViews() {
        edtUsername = (EditText) findViewById(R.id.activity_loginup_username);
        edtPassword = (EditText) findViewById(R.id.activity_loginup_password);
        edtPasswordAgain = (EditText) findViewById(R.id.activity_loginup_password_again);
        edtEmail = (EditText) findViewById(R.id.activity_loginup_email);
        btnLoginUp = (Button) findViewById(R.id.activity_loginup_login_up_btn);


        btnLoginUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                String passwordAgain = edtPasswordAgain.getText().toString();
                String email = edtEmail.getText().toString();
                if (username.equals("") || password.equals("") || passwordAgain
                        .equals("") || email.equals("")) {
                    Toast.makeText(LoginUpActivity.this, "用户名或密码，邮箱未填写", Toast
                            .LENGTH_SHORT).show();
                } else {
                    if (!password.equals(passwordAgain)) {
                        Toast.makeText(LoginUpActivity.this, "两次输入密码不一致，请重新输入",
                                Toast.LENGTH_SHORT).show();
                        edtPassword.setText("");
                        edtPasswordAgain.setText("");
                    } else {
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setEmail(email);
                        user.signUp(LoginUpActivity.this, new SaveListener() {
                            @Override
                            public void onSuccess() {
                                Toast.makeText(LoginUpActivity.this, "注册成功", Toast.LENGTH_SHORT)
                                        .show();

                                Intent intent = new Intent(LoginUpActivity.this, MainActivity.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(int i, String s) {
                                Toast.makeText(LoginUpActivity.this, "注册失败", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        });
                    }
                }
            }
        });
    }
}
