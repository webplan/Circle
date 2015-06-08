package com.zzt.circle.app.net;

import com.zzt.circle.app.Config;
import com.zzt.circle.app.entity.ImageMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzt on 15-5-25.
 */
public class Timeline {
    private Map<String, String> params = new HashMap<String, String>();

    public Timeline(String account, String token, int page, int perpage, final SuccessCallback successCallback, final FailCallback failCallback) {
        params.put(Config.KEY_ACTION, Config.ACTION_TIMELINE);
        params.put(Config.KEY_ACCOUNT, account);
        params.put(Config.KEY_TOKEN, token);
        params.put(Config.KEY_PAGE, String.valueOf(page));
        params.put(Config.KEY_PERPAGE, String.valueOf(perpage));
        new NetConnection(Config.SERVER_URL, HttpMethod.POST, new NetConnection.SuccessCallBack() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject obj = new JSONObject(result);
                    switch (obj.getInt(Config.KEY_STATUS)) {
                        case Config.RESULT_STATUS_SUCCESS:
                            if (successCallback != null) {
                                List<ImageMessage> msgs = new ArrayList<ImageMessage>();
                                JSONArray timeline = obj.getJSONArray(Config.KEY_TIMELINE);
                                System.out.println(timeline);
                                JSONObject msgObj;
                                for (int i = 0; i < timeline.length(); i++) {
                                    msgObj = timeline.getJSONObject(i);
                                    msgs.add(new ImageMessage(msgObj.getInt(Config.KEY_MSG_ID),
                                            msgObj.getString(Config.KEY_AVATAR_URL),
                                            msgObj.getString(Config.KEY_NICKNAME),
                                            msgObj.getString(Config.KEY_PHOTO_URL),
                                            msgObj.getString(Config.KEY_TEXT_DESCROPTION)));
                                }
                                successCallback.onSuccess(obj.getInt(Config.KEY_PAGE), obj.getInt(Config.KEY_PERPAGE), msgs);
                            }
                            break;
                        default:
                            if (failCallback != null)
                                failCallback.onFail();
                            break;
                    }
                } catch (JSONException e) {
                    if (successCallback != null)
                        failCallback.onFail();
                }
            }
        }, new NetConnection.FailCallBack() {
            @Override
            public void onFail() {

            }
        }, params);
    }

    public static interface SuccessCallback {
        void onSuccess(int page, int perpage, List<ImageMessage> timeline);
    }

    public static interface FailCallback {
        void onFail();
    }
}
