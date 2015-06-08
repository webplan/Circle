package com.zzt.circle.app.entity;

/**
 * Created by zzt on 15-5-18.
 */
public class ImageMessage {
    private int msgID;
    private String avatarURL;
    private String nickname;
    //    private Timestamp postTime;
    private String photoURL;
    private String textDescription;
//    private String soundDescriptionURL;


    public ImageMessage(int msgID, String avatarURL, String nickname, String photoURL, String textDescription) {
        this.msgID = msgID;
        this.avatarURL = avatarURL;
        this.nickname = nickname;
        this.photoURL = photoURL;
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

    public String getPhotoURL() {
        return photoURL;
    }

    public String getTextDescription() {
        return textDescription;
    }
}