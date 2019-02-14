package com.ls.project.recyclerview;

public class ListItem {
    String num;
    String name;
    String date;

    public ListItem(String num, String name, String date) {
        this.num = num;
        this.name = name;
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
