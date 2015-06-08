package com.zzt.circle.app.net;

import com.zzt.circle.app.Config;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by zzt on 15-5-30.
 */
public class Register {
    private HashMap<String, String> params = new HashMap<String, String>();

    public Register(String account, String password_md5, String nickname, final SuccessCallback successCallback, final FailCallback failCallback) {
        params.put(Config.KEY_ACTION, Config.ACTION_REGISTER);
        params.put(Config.KEY_ACCOUNT, account);
        params.put(Config.KEY_PASSWORD_MD5, password_md5);
        params.put(Config.KEY_NICKNAME, nickname);
        new NetConnection(Config.SERVER_URL, HttpMethod.POST, new NetConnection.SuccessCallBack() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject obj = new JSONObject(result);
                    switch (obj.getInt(Config.KEY_STATUS)) {
                        case Config.RESULT_STATUS_SUCCESS:
                            if (successCallback != null)
                                successCallback.onSuccess();
                            break;
                        default:
                            if (failCallback != null)
                                failCallback.onFail();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new NetConnection.FailCallBack() {
            @Override
            public void onFail() {
                if (failCallback != null)
                    failCallback.onFail();
            }
        }, params);
    }

    public static interface SuccessCallback {
        void onSuccess();
    }

    public static interface FailCallback {
        void onFail();
    }

}
