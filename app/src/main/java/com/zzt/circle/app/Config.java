package com.zzt.circle.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zzt on 15-5-25.
 */
public class Config {
    public static final String CHARSET = "UTF-8";
    public static final String SERVER_URL = "http://192.168.56.1:8080";
    public static final String APP_ID = "com.zzt.circle";

    public static final String ACTION_TIMELINE = "timeline";

    public static final String KEY_ACCOUNT = "account";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_PAGE = "page";
    public static final String KEY_ACTION = "action";
    public static final String KEY_PERPAGE = "perpage";
    public static final String KEY_STATUS = "status";
    public static final String KEY_TIMELINE = "timeline";
    public static final String KEY_MSG_ID = "msg_id";
    public static final String KEY_AVATAR_URL = "avatar_url";
    public static final String KEY_NICKNAME = "nickname";
    public static final String KEY_IMAGE_URL = "image_url";
    public static final String KEY_TEXT_DESCROPTION = "text_description";

    public static final int RESULT_STATUS_SUCCESS = 1;
    public static final int RESULT_STATUS_FAIL = 0;
    public static final int RESULT_STATUS_INVALID_TOKEN = 2;

    public static String getCachedToken(Context context) {
        return context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).getString(KEY_TOKEN, null);
    }

    public static void cacheToken(Context context, String token) {
        SharedPreferences.Editor e = context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
        e.putString(KEY_TOKEN, token);
        e.commit();
    }

    public static String getCachedAccount(Context context) {
        return context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).getString(KEY_ACCOUNT, null);
    }

    public static void cacheAccount(Context context, String account) {
        SharedPreferences.Editor e = context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
        e.putString(KEY_ACCOUNT, account);
        e.commit();
    }
}
