package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {

    private String id;
    private String title;
    private String imgUrl;
    private String status;
    private String content;
    private String category;
    private Date createDate;
    private Master master;

    public Article() {
    }

    public Article(String id, String title, String imgUrl, String status, String content, String category, Date createDate, Master master) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.status = status;
        this.content = content;
        this.category = category;
        this.createDate = createDate;
        this.master = master;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", status='" + status + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", createDate=" + createDate +
                ", master=" + master +
                '}';
    }
}
