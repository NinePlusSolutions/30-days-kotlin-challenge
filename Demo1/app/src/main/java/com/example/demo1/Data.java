package com.example.demo1;

public class Data {
    private final int resourceId;
    private final String name;
    private final String country;
    private final String time;
    private final String comment;
    private final int message1;
    private final int favorite;
    private final int share;

    public Data(int resourceId, String name, String country, String time, String comment, int message1, int repeat, int favorite, int share) {
        this.resourceId = resourceId;
        this.name = name;
        this.country = country;
        this.time = time;
        this.comment = comment;
        this.message1 = message1;
        this.favorite = favorite;
        this.share = share;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getTime() {
        return time;
    }

    public String getComment() {
        return comment;
    }

    public int getMessage1() {
        return message1;
    }

    public int getFavorite() {
        return favorite;
    }

    public int getShare() {
        return share;
    }

}
