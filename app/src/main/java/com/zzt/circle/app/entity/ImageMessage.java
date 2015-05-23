package com.zzt.circle.app.entity;

import java.sql.Timestamp;

/**
 * Created by zzt on 15-5-18.
 */
public class ImageMessage {
    private String imageURL;
    private Timestamp postTime;
    private String textDescription;
    private String soundDescriptionURL;
    private int msgID;
    private String nickname;
    private String avatarURL;

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Timestamp getPostTime() {
        return postTime;
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getSoundDescriptionURL() {
        return soundDescriptionURL;
    }

    public void setSoundDescriptionURL(String soundDescriptionURL) {
        this.soundDescriptionURL = soundDescriptionURL;
    }

    public int getMsgID() {
        return msgID;
    }

    public void setMsgID(int msgID) {
        this.msgID = msgID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}