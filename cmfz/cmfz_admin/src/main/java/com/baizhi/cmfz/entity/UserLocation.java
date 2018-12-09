package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class UserLocation implements Serializable {
    private String name;
    private Integer value;

    public UserLocation() {
    }

    public UserLocation(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
