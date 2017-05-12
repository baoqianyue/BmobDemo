package com.barackbao.bmobtest;

import cn.bmob.v3.BmobUser;

/**
 * Created by BarackBao on 2017/5/13.
 */

public class User extends BmobUser {
    /**
     * 这里创建用户的一些特殊属性
     * 用户名和密码是该父类以创建好的
     */

    private String email;


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}
