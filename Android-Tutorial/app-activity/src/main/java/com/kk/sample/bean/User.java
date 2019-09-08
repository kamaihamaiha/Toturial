package com.kk.sample.bean;

import java.io.Serializable;
/**
*
* @Author: kk
* @Create Date: 19-3-8 下午11:22
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is User 序列化
 * 直接实现 Serializable，该类都给处理好了。
 * 操作简单，但是速度快
*/
public class User implements Serializable{

    private String name;
    private int age;
    private String gender;

    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
