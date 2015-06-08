package com.zzt.circle.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.zzt.circle.app.activity.LoginActivity;
import com.zzt.circle.app.activity.MainActivity;

/**
 * Created by zzt on 15-6-6.
 */
public class EntryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Config.cacheToken(this, "123456");
        Config.cacheAccount(this, "zzt");
        String token = Config.getCachedToken(this);
        String account = Config.getCachedAccount(this);
        if (token == null || account == null) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
