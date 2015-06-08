package com.zzt.circle.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zzt.circle.app.Config;

/**
 * Created by zzt on 15-5-25.
 */
public class LargeImageActivity extends Activity {
    private float x;
    private float y;
    private ImageView ivLargeImage;
    private String photoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TextView debugInfo = new TextView(this);

        photoURL = getIntent().getStringExtra(Config.KEY_PHOTO_URL);
        ImageLoader imageLoader = ImageLoader.getInstance();
        ivLargeImage = new ImageView(this);
        imageLoader.displayImage(Config.SERVER_URL + photoURL, ivLargeImage);
        ivLargeImage.setAdjustViewBounds(true);

        final RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.CENTER_VERTICAL);

        final RelativeLayout layout = new RelativeLayout(this);
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(ivLargeImage, lp);
        final RelativeLayout.LayoutParams lpt = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.ALIGN_BOTTOM);
        layout.addView(debugInfo, lpt);
        setContentView(layout);

        ivLargeImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_HOVER_MOVE:
                        x = event.getX();
                        y = event.getY();
                        debugInfo.setText("x: " + x + "y: " + y + "px: " + ivLargeImage.getLeft() + "py: " + ivLargeImage.getTop() + "height: " + ivLargeImage.getHeight());

                        break;
                }
                return false;
            }
        });

        ivLargeImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return false;
            }
        });

        ivLargeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
