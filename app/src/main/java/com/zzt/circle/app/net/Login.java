package com.zzt.circle.app.net;

import com.zzt.circle.app.Config;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by zzt on 15-5-30.
 */
public class Login {
    private HashMap<String, String> params = new HashMap<String, String>();

    public Login(String account, String password_md5, final SuccessCallback successCallback, final FailCallback failCallback) {
        params.put(Config.KEY_ACTION, Config.ACCTION_LOGIN);
        params.put(Config.KEY_ACCOUNT, account);
        params.put(Config.KEY_PASSWORD_MD5, password_md5);
        new NetConnection(Config.SERVER_URL, HttpMethod.POST, new NetConnection.SuccessCallBack() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject obj = new JSONObject(result);
                    switch (obj.getInt(Config.KEY_STATUS)) {
                        case Config.RESULT_STATUS_SUCCESS:
                            if (successCallback != null) {
                                String token = obj.getString(Config.KEY_TOKEN);
                                successCallback.onSuccess(token);
                            }
                            break;
                        default:
                            if (failCallback != null)
                                failCallback.onFailCallback();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new NetConnection.FailCallBack() {
            @Override
            public void onFail() {

            }
        }, params);
    }

    public static interface SuccessCallback {
        void onSuccess(String token);
    }

    public static interface FailCallback {
        void onFailCallback();
    }
}
