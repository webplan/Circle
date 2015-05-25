package com.zzt.circle.app.activity;

import android.app.Activity;
import android.os.Bundle;
import com.zzt.circle.app.R;

/**
 * Created by zzt on 15-5-25.
 */
public class LargeImageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ImageView view = new ImageView(this);
//        view.setImageDrawable(R.drawable.default);
        setContentView(R.layout.activity_large_image);
    }
}
