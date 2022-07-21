package com.midterm.recycleviewdemo.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Comment  implements Parcelable {
    private String commentUserName;
    private String commentUserTagName;
    private String commentTime;
    private String commentContent;
    private Boolean like;

    public Comment() {
    }

    public Comment(String commentUserName, String commentUserTagName, String commentTime, String commentContent, Boolean like) {
        this.commentUserName = commentUserName;
        this.commentUserTagName = commentUserTagName;
        this.commentTime = commentTime;
        this.commentContent = commentContent;
        this.like = like;
    }

    protected Comment(Parcel in) {
        commentUserName = in.readString();
        commentUserTagName = in.readString();
        commentTime = in.readString();
        commentContent = in.readString();
        byte tmpLike = in.readByte();
        like = tmpLike == 0 ? null : tmpLike == 1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(commentUserName);
        dest.writeString(commentUserTagName);
        dest.writeString(commentTime);
        dest.writeString(commentContent);
        dest.writeByte((byte) (like == null ? 0 : like ? 1 : 2));
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String CommentUserName) {this.commentUserName = CommentUserName;}

    public String getCommentUserTagName() {
        return commentUserTagName;
    }

    public void setCommentUserTagName(String commentUserTagName) {this.commentUserTagName = commentUserTagName; }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Boolean getLike() {return like;}

    public void setLike(Boolean like) {
        this.like = like;
    }

}
