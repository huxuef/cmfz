package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private String id;
    private String user;
    private Date optionTime;
    private String resource;
    private String action;
    private String message;
    private String result;

    public Log() {
    }

    public Log(String id, String user, Date optionTime, String resource, String action, String message, String result) {
        this.id = id;
        this.user = user;
        this.optionTime = optionTime;
        this.resource = resource;
        this.action = action;
        this.message = message;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getOptionTime() {
        return optionTime;
    }

    public void setOptionTime(Date optionTime) {
        this.optionTime = optionTime;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", optionTime=" + optionTime +
                ", resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
