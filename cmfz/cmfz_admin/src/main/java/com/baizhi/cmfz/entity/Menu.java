package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {

    private String id;
    private String name;
    private String p_id;
    private String level;
    private String icon;
    private String href;
    private List<Menu> childMenu;
    public Menu() {
    }

    public Menu(String id, String name, String p_id, String level, String icon, String href, List<Menu> childMenu) {
        this.id = id;
        this.name = name;
        this.p_id = p_id;
        this.level = level;
        this.icon = icon;
        this.href = href;
        this.childMenu = childMenu;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Menu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<Menu> childMenu) {
        this.childMenu = childMenu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", p_id='" + p_id + '\'' +
                ", level='" + level + '\'' +
                ", icon='" + icon + '\'' +
                ", href='" + href + '\'' +
                ", childMenu=" + childMenu +
                '}';
    }
}
