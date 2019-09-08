package com.kk.data.callback;
/**
*
* @Author: kk
* @Create Date: 18-12-4 上午7:05
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is 数据库操作监听
*/
public interface DBOperaListener {

    /**
     * 修改操作监听
     * @param position
     */
    void onUpdate(int position);

    /**
     * 删除操作监听
     * @param position
     */
    void onDelete(int position);
}
