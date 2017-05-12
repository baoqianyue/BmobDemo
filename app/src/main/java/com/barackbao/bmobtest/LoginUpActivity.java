package com.barackbao.bmobtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
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
        LoginUp();
    }


    private void initViews() {
        edtUsername = (EditText) findViewById(R.id.activity_loginup_username);
        edtPassword = (EditText) findViewById(R.id.activity_loginup_password);
        edtPasswordAgain = (EditText) findViewById(R.id.activity_loginup_password_again);
        edtEmail = (EditText) findViewById(R.id.activity_loginup_email);
        btnLoginUp = (Button) findViewById(R.id.activity_loginup_login_up_btn);
    }


    private void LoginUp() {
        final BmobUser user = new BmobUser();
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        String passwordagain = edtPasswordAgain.getText().toString();
        String email = edtEmail.getText().toString();
        if (!(password.equals(passwordagain))) {
            Toast.makeText(this, "两次密码输入不一致，请重新输入", Toast.LENGTH_SHORT).show();
            btnLoginUp.setEnabled(false);
        } else {
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
        }


        btnLoginUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.signUp(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if (e == null) {
                            return;
                        } else {
                            return;
                        }
                    }
                });
            }
        });
    }
}
