package com.zzt.circle.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zzt.circle.app.activity.LargeImageActivity;
import com.zzt.circle.app.activity.MainActivity;

/**
 * Created by zzt on 15-6-6.
 */
public class EntryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        startActivity(new Intent(this, LargeImageActivity.class));

        Config.cacheToken(this, "812B4BA287F5EE0BC9D43BBF5BBE87FB");
        Config.cacheAccount(this, "123");
        String token = Config.getCachedToken(this);
        String account = Config.getCachedAccount(this);
//        if (token == null || account == null) {
//            startActivity(new Intent(this, LoginActivity.class));
//        } else {
            startActivity(new Intent(this, MainActivity.class));
//        }
    }
}
