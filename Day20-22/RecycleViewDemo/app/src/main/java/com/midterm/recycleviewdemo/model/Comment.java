package com.midterm.recycleviewdemo.model;

public class Comment {
    private String nameUser;
    private String tagName;
    private String time;
    private String comment;

    public Comment() {
    }

    public Comment(String nameUser, String tagName, String time, String comment) {
        this.nameUser = nameUser;
        this.tagName = tagName;
        this.time = time;
        this.comment = comment;
    }

    public String getnameUser() {
        return nameUser;
    }

    public void setnameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String gettagName() {
        return tagName;
    }

    public void settagName(String tagName) {
        this.tagName = tagName;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }

    public String getcomment() {
        return comment;
    }

    public void setcomment(String comment) {
        this.comment = comment;
    }
}
