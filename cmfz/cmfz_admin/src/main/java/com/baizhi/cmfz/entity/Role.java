package com.baizhi.cmfz.entity;

import java.util.List;

public class Role {

    private String id;
    private String name;
    private List<Premission> premissions;

    public Role(String id, String name, List<Premission> premissions) {
        this.id = id;
        this.name = name;
        this.premissions = premissions;
    }

    public Role() {
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

    public List<Premission> getPremissions() {
        return premissions;
    }

    public void setPremissions(List<Premission> premissions) {
        this.premissions = premissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", premissions=" + premissions +
                '}';
    }
}
