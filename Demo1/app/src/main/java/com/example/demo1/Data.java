package com.example.demo1;

public class Data {
    private int resourceId;
    private String name;
    private String country;
    private String time;
    private String comment;
    private int message1;
    private int repeat;
    private int favorite;
    private int share;

    public Data(int resourceId, String name, String country, String time, String comment, int message1, int repeat, int favorite, int share) {
        this.resourceId = resourceId;
        this.name = name;
        this.country = country;
        this.time = time;
        this.comment = comment;
        this.message1 = message1;
        this.repeat = repeat;
        this.favorite = favorite;
        this.share = share;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public int getMessage1() {
        return message1;
    }

    public void setMessage1(int message1) {
        this.message1 = message1;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }
}
