package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class Manager implements Serializable {

    private String id;
    private String name;
    private String password;
    private String phone;
    private Date creatDate;
    private String solt;

    public Manager() {
    }

    public Manager(String id, String name, String password, String phone, Date creatDate, String solt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.creatDate = creatDate;
        this.solt = solt;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public String getSolt() {
        return solt;
    }

    public void setSolt(String solt) {
        this.solt = solt;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", creatDate=" + creatDate +
                ", solt='" + solt + '\'' +
                '}';
    }
}
