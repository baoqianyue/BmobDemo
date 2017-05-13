package com.barackbao.bmobtest;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by BarackBao on 2017/5/13.
 */

public class User extends BmobUser {
    /**
     * 这里创建用户的一些特殊属性
     * 用户名和密码是该父类以创建好的
     */

    private BmobFile icon;

    public BmobFile getIcon() {
        return icon;
    }

    public void setIcon(BmobFile icon) {
        this.icon = icon;
    }


}
