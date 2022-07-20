package com.ngockhanh.recyclerview.model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String address;
    private String time;
    private String comment;
    private Boolean like;

    public User() {
    }

    public User(String name, String address, String time, String comment,Boolean like) {
        this.name = name;
        this.address = address;
        this.time = time;
        this.comment = comment;
        this.like = like;
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

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }
}
