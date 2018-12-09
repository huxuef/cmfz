package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Master implements Serializable {

    private String id;
    private String name;
    private String imgUrl;
    private String status;

    public Master() {
    }

    public Master(String id, String name, String imgUrl, String status) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
        this.status = status;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Master{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
