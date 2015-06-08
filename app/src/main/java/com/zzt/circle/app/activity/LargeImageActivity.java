package com.zzt.circle.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.zzt.circle.app.widget.MyCircleButton;

/**
 * Created by zzt on 15-5-25.
 */
public class LargeImageActivity extends Activity {
    private int x;
    private int y;
    private ImageView ivLargeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ImageView view = new ImageView(this);
//        view.setImageDrawable(R.drawable.default);
        LinearLayout layout = new LinearLayout(this);
        layout.addView(new MyCircleButton(this));
        setContentView(layout);
    }
}
