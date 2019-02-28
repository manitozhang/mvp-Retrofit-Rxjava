package com.rthttp.bean;

import com.rthttp.base.BaseResponse;

import java.io.Serializable;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/10/16
 * <p>
 * 登陆实体类
 */

public class LoginBean {

    /**
     * id : 16
     * username : admin
     * name : 段哥27134
     * sex : 0
     * avater : https://github.com/manitozhang/GSYVideoPlayer/blob/master/app/default_avater.png?raw=true
     * sign :
     * phoneNumber : null
     * certifyType : 0
     * certifyContent :
     */

    private int id;
    private String username;
    private String name;
    private int sex;
    private String avater;
    private String sign;
    private Object phoneNumber;
    private int certifyType;
    private String certifyContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCertifyType() {
        return certifyType;
    }

    public void setCertifyType(int certifyType) {
        this.certifyType = certifyType;
    }

    public String getCertifyContent() {
        return certifyContent;
    }

    public void setCertifyContent(String certifyContent) {
        this.certifyContent = certifyContent;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", avater='" + avater + '\'' +
                ", sign='" + sign + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", certifyType=" + certifyType +
                ", certifyContent='" + certifyContent + '\'' +
                '}';
    }
}
