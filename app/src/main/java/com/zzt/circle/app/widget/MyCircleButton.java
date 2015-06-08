package com.zzt.circle.app.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup;
import at.markushi.ui.CircleButton;

/**
 * Created by zzt on 15-6-8.
 */
public class MyCircleButton extends CircleButton {
    public MyCircleButton(Context context) {
        super(context);
        setColor(Color.argb(200, 200, 200, 200));
        setLayoutParams(new ViewGroup.LayoutParams(50, 50));
    }

    public MyCircleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCircleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
