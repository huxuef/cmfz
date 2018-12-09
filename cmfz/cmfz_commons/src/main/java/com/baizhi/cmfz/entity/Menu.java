package com.baizhi.cmfz.entity;

import java.io.Serializable;

public class Menu implements Serializable {

    private String id;
    private String name;
    private String p_id;
    private String level;

    public Menu() {
    }

    public Menu(String id, String name, String p_id, String level) {
        this.id = id;
        this.name = name;
        this.p_id = p_id;
        this.level = level;
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

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", p_id='" + p_id + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
