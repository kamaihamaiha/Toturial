package com.kk.download;

/**
 * @Author: 张开旭
 * @Date: 2019/2/26
 * @E-mail: zhangkaixu@eyecool.cn
 * @Ltd: 山东眼神智能科技有限公司(www.facekey.cn)
 * @Address: 山东省济南市高新区齐鲁软件园B座508
 * @Des: this is AndroidBasic
 */
public class CheckVersion {


    /**
     * version : 1.2.1.0
     * updateUrl : http://192.168.60.127:8010/update.apk
     * md5Sum : hfksafosjfsjoif
     */

    private String version;
    private String updateUrl;
    private String md5Sum;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getMd5Sum() {
        return md5Sum;
    }

    public void setMd5Sum(String md5Sum) {
        this.md5Sum = md5Sum;
    }
}
