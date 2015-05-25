package com.zzt.circle.app.entity;

/**
 * Created by zzt on 15-5-18.
 */
public class ImageMessage {
    private int msgID;
    private String avatarURL;
    private String nickname;
    //    private Timestamp postTime;
    private String imageURL;
    private String textDescription;
//    private String soundDescriptionURL;


    public ImageMessage(int msgID, String avatarURL, String nickname, String imageURL, String textDescription) {
        this.msgID = msgID;
        this.avatarURL = avatarURL;
        this.nickname = nickname;
        this.imageURL = imageURL;
        this.textDescription = textDescription;
    }

    public int getMsgID() {
        return msgID;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public String getNickname() {
        return nickname;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getTextDescription() {
        return textDescription;
    }
}