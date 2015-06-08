package com.zzt.circle.app.net;

import com.zzt.circle.app.Config;
import com.zzt.circle.app.entity.Hotspot;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zzt on 15-5-31.
 */
public class GetHotspot {
    private HashMap<String, String> params = new HashMap<String, String>();

    public GetHotspot(String account, String token, int msgID, int page, int perpage, final SuccessCallback successCallback, final FailCallback failCallback) {
        params.put(Config.KEY_ACTION, Config.ACTION_GET_HOTSPOT);
        params.put(Config.KEY_ACCOUNT, account);
        params.put(Config.KEY_TOKEN, token);
        params.put(Config.KEY_MSG_ID, String.valueOf(msgID));
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
                                List<Hotspot> hotspots = new ArrayList<Hotspot>();
                                JSONArray array = obj.getJSONArray(Config.KEY_HOTSPOTS);
                                JSONObject hotspot;
                                for (int i = 0; i < array.length(); i++) {
                                    hotspot = array.getJSONObject(i);
                                    hotspots.add(new Hotspot(hotspot.getInt(Config.KEY_HOTSPOT_ID),
                                            hotspot.getDouble(Config.KEY_X),
                                            hotspot.getDouble(Config.KEY_Y)));
                                }
                                successCallback.onSuccess(obj.getInt(Config.KEY_PAGE), obj.getInt(Config.KEY_PERPAGE), hotspots);
                            }
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

            }
        }, params);
    }

    public static interface SuccessCallback {
        void onSuccess(int page, int perpage, List<Hotspot> hotspots);
    }

    public static interface FailCallback {
        void onFail();
    }
}
