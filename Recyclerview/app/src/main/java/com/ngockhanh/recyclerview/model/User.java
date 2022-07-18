package com.ngockhanh.recyclerview.model;

public class User {
    private String name;
    private String address;
    private String time;
    private String comment;

    public User() {
    }

    public User(String name, String address, String time, String comment) {
        this.name = name;
        this.address = address;
        this.time = time;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
