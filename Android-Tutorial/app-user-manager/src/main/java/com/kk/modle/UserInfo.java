package com.kk.modle;

public class UserInfo {

    private int id;
    private String name;
    private String jobNum;
    private String headImgPath;

    public UserInfo(int id, String name, String jobNum, String headImgPath) {
        this.id = id;
        this.name = name;
        this.jobNum = jobNum;
        this.headImgPath = headImgPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getHeadImgPath() {
        return headImgPath;
    }

    public void setHeadImgPath(String headImgPath) {
        this.headImgPath = headImgPath;
    }
}
