package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String id;
    private String name;
    private String nickName;
    private String password;
    private String salt;
    private String phone;
    private String sex;
    private String signature;
    private String img;
    private String status;
    private String location;
    private Date createDate;
    private Date lastLogin;

    public User() {
    }

    public User(String id, String name, String nickName, String password, String salt, String phone, String sex, String signature, String img, String status, String location, Date createDate, Date lastLogin) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.sex = sex;
        this.signature = signature;
        this.img = img;
        this.status = status;
        this.location = location;
        this.createDate = createDate;
        this.lastLogin = lastLogin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", signature='" + signature + '\'' +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", createDate=" + createDate +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
