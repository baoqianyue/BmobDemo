package com.barackbao.bmobtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bmob初始化
        Bmob.initialize(this,"fe1ca7bff87c7ced0e5319e257917c1a");

    }
}
