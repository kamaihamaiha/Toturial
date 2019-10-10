package com.kk.mvvm.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;


public class LoginInfo extends BaseObservable {
    private String userName;
    private int age;

    public LoginInfo() {
    }

    public LoginInfo(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR._all);
    }

    @Bindable
    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR._all);
    }
}
