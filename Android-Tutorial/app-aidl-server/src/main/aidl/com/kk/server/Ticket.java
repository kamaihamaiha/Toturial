package com.kk.server;

import android.os.Parcel;
import android.os.Parcelable;

/**
*
* @Author: kk
* @Create Date: 19-3-10 下午3:06
* @E-mail:  kamaihamaiha@gmail.com
* @Motto:   人生苦短，就是干！
* @Des: this is Ticket
 * 序列号对象，注意读和写要严格保持顺序一致
*/
public class Ticket implements Parcelable {
    /**
     * 始发站
     */
    private String startStation;
    /**
     * 终点站
     */
    private String desStation;
    /**
     * 开始时间
     */
    private String goOffTime;
    /**
     * 到达时间
     */
    private String arriveTime;
    /**
     * 票价
     */
    private int price;

    public Ticket(String startStation, String desStation, String goOffTime, String arriveTime, int price) {
        this.startStation = startStation;
        this.desStation = desStation;
        this.goOffTime = goOffTime;
        this.arriveTime = arriveTime;
        this.price = price;
    }

    private Ticket(Parcel in){
        readFromParcel(in);
    }

    void readFromParcel(Parcel in){
        this.startStation = in.readString();
        this.desStation = in.readString();
        this.goOffTime = in.readString();
        this.arriveTime = in.readString();
        this.price = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(startStation);
        dest.writeString(desStation);
        dest.writeString(goOffTime);
        dest.writeString(arriveTime);
        dest.writeInt(price);
    }

    public static final Creator<Ticket>  CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel source) {

            return new Ticket(source);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getDesStation() {
        return desStation;
    }

    public void setDesStation(String desStation) {
        this.desStation = desStation;
    }

    public String getGoOffTime() {
        return goOffTime;
    }

    public void setGoOffTime(String goOffTime) {
        this.goOffTime = goOffTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Creator<Ticket> getCREATOR() {
        return CREATOR;
    }
}
