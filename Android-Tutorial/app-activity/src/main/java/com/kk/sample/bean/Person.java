package com.kk.sample.bean;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Author: kk
 * @Create Date: 19-3-8 下午11:52
 * @E-mail: kamaihamaiha@gmail.com
 * @Motto: 人生苦短，就是干！
 * @Des: this is Person 序列化对象
 * 操作复杂，但是这种效率更高
 */
public class Person implements Parcelable {
    private String name;
    private int age;
    private String gender;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        bundle.putInt("age", age);
        bundle.putString("name", name);
        bundle.putString("gender", gender);
        dest.writeBundle(bundle);
    }

    //定义一个泛型
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            Bundle bundle = source.readBundle();
            return new Person(bundle.getString("name"), bundle.getInt("age"), bundle.getString("gender"));
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public Person(String name, int age, String gender) {
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

    public static Creator<Person> getCREATOR() {
        return CREATOR;
    }
}
