package com.example.researchaboutrecycleview;

public class ItemDesignModel {
    private int cardView1;
    private String tv1;
    private String tv2;


    public ItemDesignModel(int cardView1, String tv1, String tv2) {
        this.cardView1 = cardView1;
        this.tv1 = tv1;
        this.tv2 = tv2;
    }

    public int getCardView1() {
        return cardView1;
    }

    public String getTv1() {
        return tv1;
    }

    public String getTv2() {
        return tv2;
    }

}
