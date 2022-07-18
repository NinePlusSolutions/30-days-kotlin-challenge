package com.example.researchaboutrecycleview;

public class ItemDesignModel {
    private String textViewUsername;
    private String textViewLocation;
    private String textViewTime;
    private String textViewContent;


    public ItemDesignModel(String textViewUsername, String textViewLocation, String textViewTime, String textViewContent) {
        this.textViewUsername = textViewUsername;
        this.textViewLocation = textViewLocation;
        this.textViewTime = textViewTime;
        this.textViewContent = textViewContent;
    }

    public String getTextViewUsername() {
        return textViewUsername;
    }

    public String getTextViewLocation() {
        return textViewLocation;
    }

    public String getTextViewTime() {
        return textViewTime;
    }

    public String getTextViewContent() {
        return textViewContent;
    }
}
